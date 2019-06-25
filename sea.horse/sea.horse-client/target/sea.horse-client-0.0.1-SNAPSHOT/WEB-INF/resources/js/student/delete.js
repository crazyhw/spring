function deleteStudent() {
    var id=$(this).parents("tr").find("th").eq(0).attr("id");
    if(confirm("是否删除？")){
        $.ajax({
            type:"post",
            url:"http://localhost:8080/seahorse/student/deleteStudent",
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
};
