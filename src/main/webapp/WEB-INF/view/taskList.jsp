<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
     <title>SimpleTaskManager</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <a class="btn btn-success" href="/tasks/add" role="button">Add new task</a><br>
    <c:if test="${!empty listTasks}">
    <table class="table">
        <caption>
            All tasks
        </caption>
        <c:if test="${!empty listTasks}">
            <tr>
                <th>Task ID</th>
                <th>Text</th>
                <th>isDone</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listTasks}" var="task">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.text}</td>
                    <td>${task.done}</td>
                    <td>
                        <a class="btn btn-primary" href="/tasks/edit/${task.id}" role="button">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    </c:if>
    <c:if test="${empty listTasks}">
        Task list is empty!
    </c:if>
</div>

<script src="/resources/jquery/3.2.0/jquery.min.js"></script>
<script src="/resources/css/bootstrap.min.js"></script>
</body>
</html>
