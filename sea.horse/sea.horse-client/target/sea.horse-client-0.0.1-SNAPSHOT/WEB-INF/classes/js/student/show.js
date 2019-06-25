function getdata() {
    document.getElementById("return").style.display="none";
    $.ajax({
        url:"http://localhost:8080/seahorse/student/all",
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
                    + "<th>" + item.sex + "</th>"
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