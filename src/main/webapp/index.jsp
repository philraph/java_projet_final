<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    </head>
    <body>
        <h1><%= "Hello World!" %></h1>
        <br/>
        <a href="hello-servlet">Hello Servlet</a>
        <h1 x-data="{ message: 'I ❤️ Alpine' }" x-text="message"></h1>
        <a href="/login">login</a>
    </body>
</html>