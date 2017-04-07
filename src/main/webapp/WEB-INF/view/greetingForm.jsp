<%--
  Created by IntelliJ IDEA.
  User: sadmin
  Date: 07.04.17
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Greeting Form</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div class="container">



<form:form modelAttribute="greetingJSP" action="greetingForm" method="post" cssClass="inline">
    <table class="table">
        <caption>Table caption</caption>

        <tr>
            <td>
                <label for="id-tag">id-long</label>
            </td>
            <td>
                <form:input id="id-tag" path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="text-tag">text</label>
            </td>
            <td>
                <form:input id="text-tag" path="content"/>
            </td>
        </tr>
    </table>
    <div>
        <button type="submit" value=" Send" class="btn btn-success" id="submit">Send</button>
    </div>
</form:form>
</div>

<script src="/resources/jquery/3.2.0/jquery.min.js"></script>
<script src="/resources/css/bootstrap.min.js"></script>

</body>
</html>
