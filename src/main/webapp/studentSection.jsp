<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 2024-01-14
  Time: 4:02 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/dashboard" var="dashboard"/>
<c:url value="/student" var="student"/>
<html>
<head>
    <title>Alura - Admin</title>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/studentStyle.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${dashboard}">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${student}">Student</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Content
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Training</a></li>
                        <li><a class="dropdown-item" href="#">Course</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link logout" href="#">
                        <button class="btn btn-outline-danger" type="button" class="btn btn-primary"
                                style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
                            Logout
                        </button>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<section>
    <div class="section-container">
        <div class="all-Student">
            <div>
                <h1 class="page-title">List Student</h1>
                <div>
                    <input type="text" placeholder="Student ID or name" class="styled-input">
                    <button type="submit" class="search-button">search</button>
                    <ul class="pagination">
                        <form action="${student}" method="get">
                            <button type="submit">Anterior</button>
                            <button type="submit">proximo</button>
                        </form>
                    </ul>
                </div>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Type Signature</th>
                        <th>Time Blocked</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Exemplo de dados da tabela (substitua com seus próprios dados) -->
                    <tr>
                        <td>1</td>
                        <td>John Doe</td>
                        <td>Full-time</td>
                        <td>2 hours</td>
                        <td><button class="icon-button block"><ion-icon name="lock-closed-outline"></ion-icon></button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="all-StudentBlocked">
            <div>
                <h1 class="page-title">List Student Blocked</h1>
                <div>
                    <input type="text" placeholder="Student ID or name" class="styled-input">
                    <button type="submit" class="search-button">search</button>
                    <ul class="pagination">
                        <li><button><a href="#" >Anterior</a></button></li>
                        <li><button><a href="#" >Próximo</a></button></li>
                    </ul>
                </div>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Type Signature</th>
                        <th>Time Blocked</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Exemplo de dados da tabela (substitua com seus próprios dados) -->
                    <tr>
                        <td>1</td>
                        <td>John Doe</td>
                        <td>Full-time</td>
                        <td>2 hours</td>
                        <td class="td-button"><button class="icon-button"><ion-icon name="lock-open-outline"></ion-icon></button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

</body>
</html>
