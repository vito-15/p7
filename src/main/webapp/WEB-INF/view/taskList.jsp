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
    <a class="btn btn-success" href="/tasks/add" role="button">Add new task</a><br>


        <form:form modelAttribute="pageDataJSP" action="/tasks" method="post">
            <table>
            <tr>
                <td><br><label>Show tasks</label></td>
            </tr>
            <tr>
                <td><form:select path="showTasks" items="${taskFilterJSP}" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td><br><label>First result</label></td>
            </tr>
            <tr>
                <td><form:input path="firstResult" cssClass="form-control" /></td>
            </tr>
            <tr>
                <td><br><label>Records on page</label></td>
            </tr>
            <tr>
                <td><form:input path="total" cssClass="form-control" /></td>
            </tr>
            </table>
            <br>
            <button type="submit" name="prev" class="btn btn-primary">Prev</button>
            <button type="submit" name="show" class="btn btn-default">Show</button>
            <button type="submit" name="next" class="btn btn-primary">Next</button>

        </form:form>

</div>
<div class="container">
    <c:if test="${!empty listTasksJSP}">
    <table class="table">
        <caption>
            <c:if test="${pageDataJSP.showTasks}==\"all\"">
                All tasks (${listTasksJSP.size()})
            </c:if>
            <c:if test="${pageDataJSP.showTasks}==\"complited\"">
                All complited tasks (${listTasksJSP.size()})
            </c:if>
            <c:if test="${pageDataJSP.showTasks}==\"nonComplited\"">
                All not complited tasks (${listTasksJSP.size()})
            </c:if>
        </caption>
        <c:if test="${!empty listTasksJSP}">
            <tr>
                <th>Task ID</th>
                <th>Text</th>
                <th>isDone</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listTasksJSP}" var="task">
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
    <c:if test="${empty listTasksJSP}">
        Task list is empty!
    </c:if>
</div>

<script src="/resources/jquery/3.2.0/jquery.min.js"></script>
<script src="/resources/css/bootstrap.min.js"></script>
</body>
</html>
