<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/login?action=LoginForm" var="login"/>
<html>
<head>
    <title>Login - Admin</title>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/admin/static/css/login.css">
    <link rel="stylesheet" type="text/css" href="/admin/static/css/warn.css">
</head>
<body>
    <c:if test="${not empty warnModel}">
        <c:import url="warnComponent.jsp"/>
    </c:if>
    <section>
        <div class="container">
            <div class="container-Form">
                <div class="container-Form-title">
                    <h1>Admin - Alura</h1>
                </div>
                <div class="container-Form-content">
                    <form action="${login}" method="post">
                        <input type="text" placeholder="User" name="email">
                        <input type="password" placeholder="Password" name="password">
                        <button type="submit">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
