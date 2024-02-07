<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/student?action=Student" var="student"/>
<c:url value="/dashboard?action=Home" var="dashboard"/>
<c:url value="/course?action=Courses" var="course"/>
<c:url value="/login?action=LogoutForm" var="logoutForm"/>
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
                        <li><a class="dropdown-item" href="${course}">Course</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link logout" href="#">
                        <form action="${logoutForm}" method="post">
                            <button class="btn btn-outline-danger" type="submit" class="btn btn-primary"
                                    style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
                                Logout
                            </button>
                        </form>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
