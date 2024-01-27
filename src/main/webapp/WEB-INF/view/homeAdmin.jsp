<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/student?action=Student" var="student"/>
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
    <link rel="stylesheet" type="text/css" href="/admin/static/css/homeStyle.css">
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
    <div class="home-section">
        <div class="section-dashboard">
            <div>
                <h1>Dashboard</h1>
            </div>
            <div class="section-cards">
                <div class="card">
                    <div class="icon-cards">
                        <ion-icon name="people-outline"></ion-icon>
                    </div>
                    <div class="inf-card">
                        <span>Students</span>
                        <p>${dashBoard.getTotalStudent()}</p>
                    </div>
                </div>
                <div class="card">
                    <div class="icon-cards" style="background-color: #2ecc71;">
                        <ion-icon name="briefcase-outline"></ion-icon>
                    </div>
                    <div class="inf-card">
                        <span>Trainings</span>
                        <p>${dashBoard.getTotalTraining()}</p>
                    </div>
                </div>
                <div class="card">
                    <div class="icon-cards" style="background-color: #e74c3c;">
                        <ion-icon name="book-outline"></ion-icon>
                    </div>
                    <div class="inf-card">
                        <span>Courses</span>
                        <p>${dashBoard.totalCourses}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
