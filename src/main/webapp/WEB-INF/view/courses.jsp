<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/course?action=CourseForm" var="courseForm"/>
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
    <link rel="stylesheet" type="text/css" href="/admin/static/css/course.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
    <c:import url="navComponent.jsp"/>
    <section>
        <div class="container-Form-Course">
                <div class="container-Form-Course-Tittle">
                    <h1>Create Course</h1>
                </div>
                <div class="container-Form-Course-inf">
                    <input type="text" id="nameCourse" placeholder="Name course" required>
                    <textarea id="descriptionCourse" id="" cols="30" rows="10" placeholder="Write description"></textarea>
                    <input type="text" id="certificateDTO" placeholder="Name certificate">
                    <label for="combo-box">Category:</label>
                    <select id="combo-box">
                        <c:forEach items="${listCategories}" var="category">
                        <option name="idCategory" value="${category.id}">${category.nameCategory}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="container-Lesson">
                    <div class="container-Lesson-create">
                        <button id="show-form-create" type="button">Create video lesson</button>
                    </div>
                    <div class="container-Form-Course-warn">
                        <span>Minimum of 3 courses</span>
                    </div>
                    <div class="container-video">
                    </div>
                </div>
                <button type="button" onclick="sendCourse()" class="container-Form-Course-create">Create course</button>
        </div>
    </section>
    <div id="container-form-create">
    </div>
    <script src="/admin/static/js/CourseService.js"></script>
</body>
</html>
