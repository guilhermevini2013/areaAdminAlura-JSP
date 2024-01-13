<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Alura - Admin</title>
    <link rel="stylesheet" href="static/css/homeStyle.css">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<body>
    <nav>
        <div class="nav-Conteiner">
            <div class="nav-content">
                <c:out value="${teste}"></c:out>
                <div><ion-icon name="mail-sharp"></ion-icon></div>
            </div>
        </div>
    </nav>

</body>
</html>
