<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>SimpleTaskManager</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
<jsp:include page="navbar.jsp" />

    <div class="container">
        <h3>Simple task manager</h3>
        Add new, edit, remove, mark as done, mark as undone.<br>
        Show tasks: all, complited, not complited with pagination<br>
        <br>
        <b>Used:</b><br>
        Intellij Idea, Java 8, Git, Mysql, Maven, Spring MVC, Hibernate, Tomcat 8, Bootstrap<br>
        <br>
        <b>Database:</b><br>
        mysql-server with database "test".<br>
        ../sql/test.sql - Created with "mysqldump -u root -p test > test.sql".<br>
        Contains table "Task" with test data.<br>
        <br>
        To restore db test from test.sql you need to run:<br>
        mysql -u root -p test < test.sql<br>
        !!!Warning: this command will drop table "Task" from db "test" and create new from .sql file.<br>
        <br>
        <b>Db connection:</b><br>
        File dispatcher-servlet.xml contains connection data.<br>
        You may change it to your db  connection.<br>
        beans:property name="driverClassName" value="com.mysql.jdbc.Driver"<br>
        beans:property name="url" value="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8"<br>
        beans:property name="username" value="root" <br>
        beans:property name="password" value="root" <br>

    </div>

    <script src="/resources/jquery/3.2.0/jquery.min.js"></script>
    <script src="/resources/css/bootstrap.min.js"></script>
</body>

</html>