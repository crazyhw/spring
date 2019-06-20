<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/17
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:
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
            <a class="navbar-brand" href="/seahorse/">海马海马</a>
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
                <li><a href="/seahorse/student/stu" target="_ext">所有学生信息</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">商家管理</a></li>
                <li><a href="">货物</a></li>
                <li><a href="">仓储</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">订单管理</a></li>
                <li><a href="">支付管理</a></li>
                <li><a href="">配送管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">商家评价</a></li>
                <li><a href="">商品评价</a></li>
            </ul>
        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">
            <h2 class="sub-header">订单信息</h2>
            <div class="row">
                <div class="col-lg-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="请输入订单号" id="write">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" onclick="searchorder()">查询</button>
                        </span>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table table-striped" id="xinxi">
                    <thead>
                    <tr>
                        <th>订单号</th>
                        <th>订单名称</th>
                        <th>订单总价</th>
                        <th>订单数量</th>

                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <input type="button" class="btn btn-primary"  data-toggle="modal" data-target="#myModal" value="添加" id="add" />

            <input type="button" class="btn btn-primary" style="display:none;float:right" id="return" value="返回" onclick="getorder()"/>

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 10%">
                <div class="modal-dialog" style="width:300px">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="clearModal()"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">添订单</h4>
                        </div>
                        <div class="modal-body" id="myModalBody">
                            <div class="input-group my-center">
                                <span class="input-group-addon">订单</span>
                                <input type="text" class="form-control" placeholder="请输入订单号" id="num">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">订单名称</span>
                                <input type="text" class="form-control" placeholder="请输入订单名称" id="name">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">订单总价</span>
                                <input type="text" class="form-control" placeholder="请输入订单总价" id="sex">
                            </div>
                            <br/>
                            <div class="input-group my-center">
                                <span class="input-group-addon">订单数量</span>
                                <input type="text" class="form-control" placeholder="请输入订单数量" id="major">
                            </div>
                            <br/>

                        </div>
                        <div class="modal-footer">
                            <button id="modal-submit" type="button" class="btn btn-primary" onclick="addStudent()">确认</button>
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

    -->
</footer>

<script type="application/javascript">

    $(function(){
        getorder();
    });

    function getorder() {
        document.getElementById("return").style.display="none";
        $.ajax({
            url:"http://localhost:8080/seahorse/order/getorder",
            type:"get",
            dataType:"JSON",
            async:false,
            success:function (data) {
                $("tbody").children().remove();
                $.each(data, function (index, item) {
                    $("tbody").append(
                        "<tr>"
                        + "<th scope='row' id='"+item.id+"'>" + item.num + "</th>"
                        + "<th>" + item.name + "</th>"
                        + "<th>" + item.num + "</th>"
                        + "<th>" + item.major + "</th>"
                        + "<th>" + item.grade + "</th>"
                        + "<th>" + item.cla + "</th>"
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
                url:"http://localhost:8080/seahorse/deleteStudent",
                data:id ,
                dataType:"JSON",
                async:false,
                contentType:"application/json;charset=utf-8",
                success:function(data){
                    if (data==true) {
                        getorder();
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

    function addorder(){
        var order = {};
        order.num=$('#num').val();
        order.name=$('#name').val();
        order.sex=$('#sex').val();
        order.major=$('#major').val();
        order.grade=$('#grade').val();
        order.cla=$('#cla').val();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/addorder",
            data: JSON.stringify(order),
            dataType:"JSON",
            async:false,
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                if(data==true) {
                    $("#myModal").modal('hide');
                    getorder();
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
        for (var i = 0, j = 0; i < 6; i++, j++) {
            model.eq(i).val(data.eq(j).text());
        }
        $("#modal-submit").attr("onclick", "updateStudent("+id+")");
    });
    function clearModal() {
        var properties = $("#myModalBody").children("div").find("input");
        for(var i = 0; i < 6; i++) {
            properties.eq(i).val("");
        }
    }
    function updateStudent(id) {
        var student = {};
        student.id=id;
        student.num=$('#num').val();
        student.name=$('#name').val();
        student.sex=$('#sex').val();
        student.major=$('#major').val();
        student.grade=$('#grade').val();
        student.cla=$('#cla').val();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/updateorder",
            data: JSON.stringify(order),
            dataType:"JSON",
            async:false,
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                if(data==true) {
                    $("#myModal").modal('hide');
                    getorder();
                }else{
                    alert("修改失败！");
                }
            },
            error:function () {
                alert("错误！");
            }
        })
    }

    function searchorder() {
        var num=$("#write").val();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/searcorder",
            data:num ,
            dataType:"JSON",
            async:false,
            contentType:"application/json;charset=utf-8",
            success:function(data){
                if (data!=null) {
                    $("tbody").children().remove();
                    $("tbody").append(
                        "<tr>"
                        + "<th scope='row' id='"+data.id+"'>" + data.num + "</th>"
                        + "<th>" + data.name + "</th>"
                        + "<th>" + data.sex + "</th>"
                        + "<th>" + data.major + "</th>"
                        + "<th>" + data.grade + "</th>"
                        + "<th>" + data.cla + "</th>"
                        + "<th>" + "<button class='btn btn-primary btn-sm update ' data-toggle='modal' data-target='#myModal'>修改</button>"
                        + "<button class='btn btn-danger btn-sm delete'>删除</button>" + "</th>"
                        + "</tr>"
                    )
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
