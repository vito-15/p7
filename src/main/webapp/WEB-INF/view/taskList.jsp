<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>SimpleTaskManager</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

<c:if test="${!empty listTasks}">

</c:if>

<div class="container">
    <table class="table">
        <caption>
            <c:if test="${!empty listTasks}">
                Список всех задач
            </c:if>
            <c:if test="${empty listTasks}">
                Список задач пуст
            </c:if>
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
                        <a class="btn btn-primary" href="/taskEdit/${task.id}" role="button">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

    </table>
</div>






<script src="/resources/jquery/3.2.0/jquery.min.js"></script>
<script src="/resources/css/bootstrap.min.js"></script>
</body>
</html>
