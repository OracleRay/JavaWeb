<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post" id="form">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            <span id="true_name" class="error"></span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="jiguan">籍贯：</label>
            <select name="address" class="form-control" id="jiguan">
                <option value="山西">山西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码" id="qq"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="email" class="form-control" name="email" placeholder="请输入邮箱地址" id="email"/>
            <span id="true_email" class="error"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>

<script>
    window.onload = function (){
        document.getElementById("form").onsubmit = function (){
            return checkName() && checkEmail();
        }
        document.getElementById("name").onblur = checkName;
        document.getElementById("email").onblur = checkEmail;
    }
    function checkName(){
        let name = document.getElementById("name").value;
        let checkName = /^[\u4e00-\u9fa5]{1,8}$/;
        let flag = checkName.test(name);
        if(flag){
            document.getElementById("true_name").innerHTML = "<p style='color: #4cae4c'>格式正确</p>";
        }
        else{
            document.getElementById("true_name").innerHTML = "<p style='color: red'>格式错误</p>";
        }
        return flag;
    }
    function checkEmail(){
        let email = document.getElementById("email").value;
        let checkEmail = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let flag = checkEmail.test(email);
        let true_email = document.getElementById("true_email");
        if(flag){
            true_email.innerHTML = "<p style='color: #4cae4c'>格式正确</p>";
        }
        else{
            true_email.innerHTML = "<p style='color: red'>格式错误</p>";
        }
        return flag;
    }
</script>

</body>
</html>
