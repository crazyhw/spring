function addStudent(){
    var student = {};
    student.num=$('#num').val();
    student.name=$('#name').val();
    student.sex=$('#sex').val();
    student.major=$('#major').val();
    student.grade=$('#grade').val();
    student.cla=$('#cla').val();
    $.ajax({
        type:"post",
        url:"http://localhost:8080/seahorse/student/addStudent",
        data: JSON.stringify(student),
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
