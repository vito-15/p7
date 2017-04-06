<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Index Page</title>
</head>

<body>
    <a href="welcome">welcome link</a><br>

    <h3>Welcome, Enter The Employee Details</h3>

    <form:form method="POST" action="addEmployee" modelAttribute="employee">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td><form:label path="contactNumber">Contact Number</form:label></td>
                <td><form:input path="contactNumber"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>


</body>

</html>