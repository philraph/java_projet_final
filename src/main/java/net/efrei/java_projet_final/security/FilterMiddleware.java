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

        HttpSession session = httpRequest.getSession();

        String servletName = ((HttpServletRequest) request).getHttpServletMapping().getServletName();
        Protected protectedAnnotation = null;
        try {
            protectedAnnotation = (Protected) Class.forName(servletName).getAnnotation(Protected.class);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + servletName);
        }

        if(protectedAnnotation == null) {
            chain.doFilter(request, response);
            return;
        }

        Group[] necessaryGroups = protectedAnnotation.value();

        Utilisateur user = (Utilisateur) session.getAttribute("user");

        if(!_userService.hasGroups(user, necessaryGroups)) {
            if(Arrays.asList(necessaryGroups).contains(Group.GUEST)) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/dashboard");
                return;
            }

            httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}