
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/student?action=UnblockStudent" var="unblockStudent"/>
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
    <link rel="stylesheet" type="text/css" href="/admin/static/css/studentStyle.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<c:import url="navComponent.jsp"/>
<div id="container-form-block">
</div>
<section>
    <div class="section-container">
        <div class="all-Student">
            <div>
                <h1 class="page-title">List Student</h1>
                <div>
                    <input type="text" placeholder="Search student unblock by name" class="styled-input" id="formFindUnblock">
                    <button type="submit" class="search-button" id="searchUnblock">search</button>
                    <ul class="pagination">
                        <li>
                            <button><a id="before">before</a></button>
                        </li>
                        <li>
                            <button><a id="next">next</a></button>
                        </li>
                    </ul>
                </div>
                <div class="table-Student">
                    <table id="table-Unblocked">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Type Signature</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allStudentUnblock}" var="studentUnblock">
                            <tr>
                                <td>${studentUnblock.id}</td>
                                <td>${studentUnblock.name}</td>
                                <td>${studentUnblock.typeSignature}</td>
                                <td>
                                    <button class="icon-button block" name="idStudent" value="${studentUnblock.id}" id="show-form-block">
                                        <ion-icon name="lock-closed-outline"></ion-icon>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
                <c:if test="${empty allStudentUnblock}">
                    <p>No result</p>
                </c:if>
            </div>
        </div>

        <div class="all-StudentBlocked">
            <div>
                <h1 class="page-title">List Student Blocked</h1>
                <div>
                    <input type="text" placeholder="Search student block by name" class="styled-input" id="formFindBlock">
                    <button type="submit" class="search-button" id="searchBlock">search</button>
                    <ul class="pagination">
                        <li>
                            <button><a id="before-block">before</a></button>
                        </li>
                        <li>
                            <button><a id="next-block">next</a></button>
                        </li>
                    </ul>
                </div>
                <div class="table-Student">
                    <table id="table-blocked">
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
                        <c:forEach items="${allStudentBlock}" var="studentBlock">
                            <tr>
                                <td>${studentBlock.id}</td>
                                <td>${studentBlock.name}</td>
                                <td>${studentBlock.typeSignature}</td>
                                <td>${studentBlock.timeBlocked}</td>
                                <td>
                                    <form action="${unblockStudent}" method="post">
                                        <button class="icon-button" name="idStudent" value="${studentBlock.id}">
                                            <ion-icon name="lock-open-outline"></ion-icon>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <c:if test="${empty allStudentBlock}">
                    <p>No result</p>
                </c:if>
            </div>
        </div>
    </div>
</section>
<script src="/admin/static/js/ListedUnblockStudent.js"></script>
<script src="/admin/static/js/ListedBlockStudent.js"></script>
<script src="/admin/static/js/FindStudent.js"></script>
</body>
</html>
