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
    <link rel="stylesheet" type="text/css" href="/admin/static/css/course.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
    <c:import url="navComponent.jsp"/>
    <section>
        <div class="container-Form-Course">
            <form action="" method="post">
                <div class="container-Form-Course-Tittle">
                    <h1>Create Course</h1>
                </div>
                <div class="container-Form-Course-inf">
                    <input type="text" name="nameCourse" placeholder="Name course" required>
                    <textarea name="descriptionCourse" id="" cols="30" rows="10" placeholder="Write description"></textarea>
                    <input type="url" placeholder="Course image URL">
                </div>
                <div class="container-Form-Course-warn">
                    <span>Minimum of 3 courses</span>
                </div>
                <div class="container-Lesson">
                    <div class="container-Lesson-create">
                        <button>Create video lesson</button>
                    </div>
                </div>
                <button type="submit" class="container-Form-Course-create">Create</button>
            </form>
        </div>
    </section>
</body>
</html>
