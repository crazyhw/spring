function searchStudent() {
    var num=$("#write").val();
    $.ajax({
        type:"post",
        url:"http://localhost:8080/seahorse/student/searchStudent",
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