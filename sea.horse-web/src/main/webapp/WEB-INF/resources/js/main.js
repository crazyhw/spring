function createTableHead() {
    $("#my-head").html("");
    $("#my-head").append(
        "<tr><th>学号</th><th>姓名</th><th>性别</th><th>专业</th><th>年级</th><th>班级</th><th></th></tr>");
}

function getData() {
    $.ajax({
        url: '/osals/stu/allToString',
        type: 'GET',
        data: {

        },
        async:false,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data != null){
                fillTable(data);
            }
        },
        error: function () {
            alert('亲，学生数据获取失败啦！')
        }

    })
}

function fillTable(data) {
    var studentList = data.list;
    var studentSize = data.size;
    $("#my-tbody").html("");
    for (var i = 0; i < studentSize; i++) {
        $("#my-tbody").append(
            "<tr><th scope='row' sno='" + studentList[i].sno + "'></th><th>" + studentList[i].name + "</th><th>"
            + studentList[i].sex + "</th><th>" + studentList[i].major + "</th><th>"
            + studentList[i].grade + "</th><th>" + studentList[i].sclass + "</th><th>"
            + "<button class='btn btn-primary btn-sm stu-edit' data-toggle='modal' data-target='#myModal'> 编辑 " +
            "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>"
            + " " + "<button class='btn btn-danger btn-sm stu-delete'><span class='glyphicon glyphicon-trash'" +
            " aria-hidden='true'></span>删除</button></th></tr>"
        );
    }
}

function addListener() {
    $(document).on("click", ".stu-delete", function () {
        var sno = $(this).parents("tr").find("th").eq(0).attr("sno");
        $.ajax({
            url: '/osals/stu/delete',
            type: 'DELETE',
            data: JSON.stringify({
                "sno":sno
            }),
            async: false,
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                if(data === true) {
                    alert("删除成功！");
                    location.reload();
                } else {
                    alert("删除失败！");
                }
            },
            error: function () {
                alert('异常');
            }
        });
    });
}