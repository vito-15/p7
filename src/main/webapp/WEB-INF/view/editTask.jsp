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
    <form:form modelAttribute="taskJSP" action="/tasks/edit" method="post">
        <table class="table">
            <caption>Edit task</caption>
            <tr>
                <td><label>ID</label></td>
                <td><form:input path="id" readonly="true" disabled="true"/></td>
                <form:hidden path="id" />
            </tr>
            <tr>
                <td><label>Input text</label></td>
                <td><form:input path="text" /></td>
            </tr>
            <tr>
                <td><label>isDone</label></td>
                <td><form:input path="done" readonly="true" disabled="true"/></td>
                <form:hidden path="done" />
            </tr>
        </table>
        <div>
            <button type="submit" value=" Send" class="btn btn-success" id="submit">Save</button>
            <a class="btn btn-primary" href="/tasks/complite/${taskJSP.id}" role="button">Complite</a>
            <a class="btn btn-primary" href="/tasks/noncomplite/${taskJSP.id}" role="button">NonComplite</a>
            <a class="btn btn-danger" href="/tasks/remove/${taskJSP.id}" role="button">Remove</a>
        </div>
    </form:form>
</div>





<script src="/resources/jquery/3.2.0/jquery.min.js"></script>
<script src="/resources/css/bootstrap.min.js"></script>
</body>
</html>
