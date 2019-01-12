function checkLogin() {
    var role=$("#select_role").val();
    var password=$("#pwd").val();
    var username=$("#username").val();
    if(username==null||username==""){
        $("#username").value="用户名不为空";
    }else if(password==null||password==""){
        $("#pwd").value="密码不为空";
    }else{
        var data={
                username:username,
                password:password,
                role: parseInt(role)
            };
        $.ajax({
            url : "/user/loginCheck.do",
            type : "POST",
            data :JSON.stringify(data),
            dataType: 'json',
            async:true,
            contentType:'application/json;charset=UTF-8', //contentType
            success :function (data) {
                console.log(data.status);
                console.log(data.user);
                if(data.status=="success"){
                    if(data.user.role==0){
                        window.location.href="/order.html?uID="+data.user.username;
                    }else{
                        window.location.href="/index.html?uID="+data.user.username;
                    }
                }

                else{
                    alert("用户名或者密码错误");
                }
            },
            error :function (data) {
                console.log(data.status);
            }
        });
    }
}