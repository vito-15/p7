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


<div class="navbar-left">
    <table>
        <tr>
            <td>
                <a class="btn btn-success" href="/tasks/add" role="button">Add new task</a>
            </td>
        </tr>
        <tr>
            <td>
                <br>
                <div class="col-sm-5">
                </div>
                    <select ng-model='discussionsSelect' class='form-control' >
                        <option value='all'>Show all tasks</option>
                        <option value='notComplited' selected>Show not complited tasks</option>
                        <option value='complited'>Show complited tasks</option>
                    </select>
                <br>
            </td>
        </tr>
        <tr>
            <td>
                <div class="form-group">
                    <label for="number-input1">First result</label>
                    <input type="number" class="form-control" id="number-input1" value="0">
                </div>
                <div class="form-group">
                    <label for="number-input2">Results on page</label>
                    <input type="number" class="form-control" id="number-input2" value="20">
                </div>
                <a class="btn btn-default" href="/tasks/blank" role="button">Defaults</a>
                <a class="btn btn-primary" href="/tasks/prev" role="button">Prev</a>
                <a class="btn btn-primary" href="/tasks/next" role="button">Next</a>
            </td>
        </tr>
    </table>
</div>
<div class="container">
    <c:if test="${!empty listTasks}">
    <table class="table">
        <caption>
            All tasks (${listTasks.size()})
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
                        <a class="btn btn-default" href="/tasks/edit/${task.id}" role="button">Edit</a>
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
