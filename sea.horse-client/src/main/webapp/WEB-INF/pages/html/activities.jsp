<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>海马</title>
    <base href=" <%=basePath%>">
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
                <!--<li class="active"><a href="#">学生管理</a></li>-->
                <li><a href="activities/act">店铺活动</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="activities/act">活动信息</a></li>
                <li><a href="shop/sho">店铺活动信息</a></li>
            </ul>
        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">
            <h2 class="sub-header">店铺活动</h2>
            <div class="row">
                <div class="col-lg-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="请输入活动编号" id="write">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" onclick="searchActivities()">查询</button>
                        </span>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table table-striped" id="xinxi">
                    <thead>
                    <tr>
                        <th>活动编号</th>
                        <th>活动类型</th>
                        <th>活动内容</th>
                        <th>活动持续时间</th>
                        <th>店铺名</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <input type="button" class="btn btn-primary"  data-toggle="modal" data-target="#myModal" value="添加" id="add" />

            <input type="button" class="btn btn-primary" style="display:none;float:right" id="return" value="返回" onclick="getdata()"/>

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 10%">
                <div class="modal-dialog" style="width:300px">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="clearModal()"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">添加活动</h4>
                        </div>
                        <div class="modal-body" id="myModalBody">
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">活动编号</span>
                                <input type="text" class="form-control" placeholder="请输入活动编号" id="num">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">活动类型</span>
                                <input type="text" class="form-control" placeholder="请输入活动类型" id="type">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">活动内容</span>
                                <input type="text" class="form-control" placeholder="请输入活动内容" id="content">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">活动持续时间</span>
                                <input type="text" class="form-control" placeholder="请输入活动持续时间" id="date">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">店铺名</span>
                                <input type="text" class="form-control" placeholder="请输入店铺名" id="name">
                            </div>
                            <br/>
                        </div>
                        <div class="modal-footer">
                            <button id="modal-submit" type="button" class="btn btn-primary" onclick="addActivities()">确认</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </div>
    </div>
</div>


<footer>
    <!--
        <p class="pull-right">?2019 Company</p>
    -->
</footer>

<script type="application/javascript">

    $(function(){
        getdata();
    });

    function getdata() {
        document.getElementById("return").style.display="none";
        $.ajax({
            url:"http://localhost:8080/seahorse/activities/all",
            type:"get",
            dataType:"JSON",
            async:false,
            success:function (data) {
                $("tbody").children().remove();
                $.each(data, function (index, item) {
                    $("tbody").append(
                        "<tr>"
                        + "<th scope='row' id='"+item.id+"'>" + item.num + "</th>"
                        + "<th>" + item.type + "</th>"
                        + "<th>" + item.content + "</th>"
                        + "<th>" + item.date + "</th>"
                        + "<th>" + item.shop.name + "</th>"
                        + "<th>" + "<button class='btn btn-primary btn-sm update ' data-toggle='modal' data-target='#myModal'>修改</button>"
                        + "<button class='btn btn-danger btn-sm delete'>删除</button>" + "</th>"
                        + "</tr>"
                    )
                })
            },
            error:function () {
                alert("获取信息失败!");
            },
        })
    }

    $(document).on("click", ".delete", function () {
        var id=$(this).parents("tr").find("th").eq(0).attr("id");
        if(confirm("是否删除？")){
            $.ajax({
                type:"post",
                url:"http://localhost:8080/seahorse/activities/deleteActivities",
                data:id ,
                dataType:"JSON",
                async:false,
                contentType:"application/json;charset=utf-8",
                success:function(data){
                    if (data==true) {
                        getdata();
                    }else{
                        alert("删除失败！");
                    }
                },
                error:function(){
                    alert("删除失败!");
                },
            })
        }
    });

    function addActivities(){
        var activities = {};
        var shops= {};
        shops.name=$('#name').val();
        activities.num=$('#num').val();
        activities.type=$('#type').val();
        activities.content=$('#content').val();
        activities.date=$('#date').val();
        activities.shop=shops;
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/activities/addActivities",
            data: JSON.stringify(activities),
            dataType:"JSON",
            async:false,
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                if(data==true) {
                    $("#myModal").modal('hide');
                    getdata();
                }else{
                    alert("添加失败！");
                }
            },
            error:function () {
                alert("错误！");
            }
        })
    }


    $(document).on("click", ".update", function () {
        clearModal();
        var model = $("#myModalBody").children("div").find("input");
        var id = $(this).parents("tr").find("th").eq(0).attr("id");
        var data = $(this).parents("tr").find("th");
        for (var i = 0, j = 0; i < 5; i++, j++) {
            model.eq(i).val(data.eq(j).text());
        }
        $("#modal-submit").attr("onclick", "updateActivities("+id+")");
    });
    function clearModal() {
        var properties = $("#myModalBody").children("div").find("input");
        for(var i = 0; i < 5; i++) {
            properties.eq(i).val("");
        }
    }
    function updateActivities(id) {
        var activities = {};
        var shops= {};
        activities.id=id;
        shops.name=$('#name').val();
        activities.num=$('#num').val();
        activities.type=$('#type').val();
        activities.content=$('#content').val();
        activities.date=$('#date').val();
        activities.shop=shops;
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/activities/updateActivities",
            data: JSON.stringify(activities),
            dataType:"JSON",
            async:false,
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                if(data==true) {
                    $("#myModal").modal('hide');
                    getdata();
                    $("#modal-submit").attr("onclick", "addActivities()");
                }else{
                    alert("修改失败！");
                }
            },
            error:function () {
                alert("错误！");
            }
        })
    }

    function searchActivities() {
        var name=$("#write").val();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/activities/searchActivities",
            data:name ,
            dataType:"JSON",
            async:false,
            contentType:"application/json;charset=utf-8",
            success:function(data){
                if (data!=null) {
                    $("tbody").children().remove();
                    $.each(data, function (index, it) {
                    $("tbody").append(
                        "<tr>"
                        + "<th scope='row' id='"+it.id+"'>" + it.num + "</th>"
                        + "<th>" + it.type + "</th>"
                        + "<th>" + it.content + "</th>"
                        + "<th>" + it.date + "</th>"
                        + "<th>" + it.shop.name + "</th>"
                        + "<th>" + "<button class='btn btn-primary btn-sm update ' data-toggle='modal' data-target='#myModal'>修改</button>"
                        + "<button class='btn btn-danger btn-sm delete'>删除</button>" + "</th>"
                        + "</tr>"
                    )})
                    document.getElementById("return").style.display="block";
                }else{
                    alert("未找到！");
                }
            },
            error:function(){
                alert("查询失败!");
            },
        })
    }
</script>

</body>
</html>