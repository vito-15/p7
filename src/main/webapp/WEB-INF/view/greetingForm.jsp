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
</head>
<body>
<form:form modelAttribute="greetingJSP" action="greetingForm" method="post" cssClass="inline">
    <fieldset>
        <div class="span-8">
            <label for="id-tag">id-long</label>
            <form:input id="id-tag" path="id"/>
        </div>
        <div class="span-8">
            <label for="text-tag">text</label>
            <form:input id="text-tag" path="content"/>
        </div>
        <input type = "submit" value = "Submit"/>
    </fieldset>
</form:form>


</body>
</html>
