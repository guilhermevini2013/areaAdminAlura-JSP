<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:import url="navComponent.jsp"/>
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
