function updata() {
    clearModal();
    var model = $("#myModalBody").children("div").find("input");
    var id = $(this).parents("tr").find("th").eq(0).attr("id");
    var data = $(this).parents("tr").find("th");
    for (var i = 0, j = 0; i < 6; i++, j++) {
        model.eq(i).val(data.eq(j).text());
    }
    $("#modal-submit").attr("onclick", "updateStudent("+id+")");
};
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
        url:"http://localhost:8080/seahorse/student/updateStudent",
        data: JSON.stringify(student),
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
