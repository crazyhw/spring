<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/19
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>海马</title>

<script src="resources/js/jquery-3.3.1.min.js" type="text/javascript" ></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js" type="text/javascript"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<link href="resources/css/styles.css" rel="stylesheet" type="text/css">

<%--<script src="resources/js/student/show.js"></script>--%>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/seahorse">海马</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Sign in</a></li>
                <li><a href="#">Register</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <div class="row row-offcanvas row-offcanvas-left">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">

            <ul class="nav nav-sidebar">
                <li><a href="student/stu">学生管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="dealer/dea">商家管理</a></li>
                <li><a href="cargo/car">货物管理</a></li>
                <li><a href="goods/goo">仓储管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="activities/act">商家活动</a></li>
                <li><a href="#">订单管理</a></li>
                <li><a href="#">配送管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="merchant/mer">评价管理</a></li>
                <li><a href="appraise/app">监督管理</a></li>
            </ul>
        </div><!--/span-->

        <div class="container-fluid">
            <div class="row row-offcanvas row-offcanvas-left">
                <div class="starter-template">
                <h1>Hello SeaHorse</h1>
                <p class="lead">Welcome to seahorse<br> 欢迎来到海马的世界</p>
                </div>
            </div>
        </div>

</div>

</body>
</html>
