<%--
  Created by IntelliJ IDEA.
  User: MI'
  Date: 2020/7/22
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛 新增</title>
</head>
<body>
    <form action="coninsert" method="post">
        <input type="text" placeholder="请输入标题" name="title">
        <br/>
        <textarea cols="10" rows="10" name="content"></textarea>
        <br/>
        ${requestScope.err}
        <br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
