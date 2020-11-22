<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/27
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户查询</title>

    <script type="text/javascript">
        function doDelete(sid) {
            /* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。
            如何知道用户点击的是确定。
            如何在js的方法中请求servlet。 */
            var flag = confirm("是否确定删除?");
            if(flag){
                //表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
                //window.location.href="DeleteServlet?sid="+sid;
                location.href="DeleteServlet?deleteId="+sid;
            }
        }
    </script>

</head>
<body>
<form>
    <p>按姓名查询: <input name="username"></p>
    <input type="button" id="btn" value="查询">
    <a href="index.jsp">添加</a>
</form><script src="js/jquery-3.3.1.min.js"></script>
<script>
    $("#btn").on("click",function(){
        $.post("selectUsersByName", $("form").serialize() ,function( result ){ },"json" );
    });
</script>
    <table border="1" width="700">

        <tr align="center">
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>电话</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${result }" var="user">
            <tr align="center">
                <td>${user.id }</td>
                <td>${user.username }</td>
                <td>${user.password }</td>
                <td>${user.phone }</td>
                <td><a href="updateUser?id=${user.id }">更新</a>   <a href="#" onclick="doDelete(${user.id})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
