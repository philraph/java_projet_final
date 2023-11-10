package net.efrei.java_projet_final.security;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class FilterMiddleware implements Filter {

    @Inject
    private UtilisateurService _userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if(httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + "/resources")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession();

        String servletName = ((HttpServletRequest) request).getHttpServletMapping().getServletName();

        if(servletName.equals("default")) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/dashboard");
            return;
        }

        Protected protectedAnnotation = null;
        try {
            protectedAnnotation = Class.forName(servletName).getAnnotation(Protected.class);
        } catch (ClassNotFoundException ignored) {}

        if(protectedAnnotation == null) {
            chain.doFilter(request, response);
            return;
        }

        Group[] necessaryGroups = protectedAnnotation.value();

        Utilisateur user = (Utilisateur) session.getAttribute("user");

        System.out.println("User " + user + " for necessary groups " + Arrays.toString(necessaryGroups));

        boolean authPage = necessaryGroups.length == 1 && necessaryGroups[0] == Group.GUEST;

        if(authPage && user == null) {
            chain.doFilter(request, response);
            return;
        } else if (authPage) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/dashboard");
            return;
        } else if (user == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login");
            return;
        }

        request.setAttribute("user", user);
        request.setAttribute("userGroups", _userService.getUserGroups(user));

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}