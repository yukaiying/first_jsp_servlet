<%--
  Created by IntelliJ IDEA.
  User: MI'
  Date: 2020/7/22
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>论坛 列表</title>
    <script src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
<input type="text" placeholder="请输入搜索title" id="search_text">
<input type="button" value="搜索" onclick="searchContent()">
<br/>
<input type="button" value="新增论坛" onclick="hrefInsertJsp()">
    <table border="1" id="content_table">
        <c:forEach items="${requestScope.list}" var="con">
            <tr>
                <td>${con.id}</td>
                <td>${con.title}</td>
                <td>${con.content}</td>
                <td>${con.createTime}</td>
                <td><input type="button" value="删除" onclick="window.location='conlist'"></td>
            </tr>
        </c:forEach>
    </table>
<input type="hidden" id="pageIndex" value="0">
首页
<input type="button" value="上一页" onclick="prePage()">
<input type="number"> 跳转
<input type="button" value="下一页" onclick="nextPage()">
尾页
<script>
    function hrefInsertJsp() {
        location.href = "coninsert.jsp";
    }
    function nextPage() {
        page(parseInt($("#pageIndex")[0].value) + 2,$("#search_text")[0].value)
    }
    function prePage() {
        page(parseInt($("#pageIndex")[0].value)-2,$("#search_text")[0].value);
    }
    function searchContent() {
        page($("#pageIndex")[0].value,$("#search_text")[0].value)
    }
    function page(pageIndex,searchContent) {
        $.post("conlist",
            {
                "aa":$("a").innerHTML,
                "searchText":searchContent,
            }
            ,function (data) {
                var rsultList = JSON.parse(data);
                var htmlContent = '';
                for(var con of rsultList){
                    htmlContent += `<tr>
                <td>${'${con.id}'}</td>
                <td>${'${con.title}'}</td>
                <td>${'${con.content}'}</td>
                <td>${'${con.createTime}'}</td>
            </tr>`;
                }
                $("#content_table")[0].innerHTML=htmlContent;
                $("#pageIndex")[0].value = pageIndex;
            });
    }
</script>
</body>
</html>
