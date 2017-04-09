<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>SimpleTaskManager</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">SimpleTaskManager</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index">Описание<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="tasksCreate">Создать задачу<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="tasks">tasks<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="tasksListAll">Все задачи<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="tasksListDone">Выполненые задачи<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="tasksListNotDone">Невыполненные задачи<span class="sr-only">(current)</span></a></li>

            </ul>
        </div>
    </div>
</nav>


    <div class="container">

        <a href="greeting">greeting link</a><br>
        <a href="http://localhost:8080/greeting?name=User">greeting User link</a><br>
        <a href="greetingForm">greetingForm link</a><br>
    </div>

    <script src="/resources/jquery/3.2.0/jquery.min.js"></script>
    <script src="/resources/css/bootstrap.min.js"></script>
</body>

</html>