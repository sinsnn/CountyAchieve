<%-- 
    Document   : error
    Created on : 2017/5/7, 下午 12:10:41
    Author     : sinsnn
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增會員失敗</title>
    </head>
    <body>
        <h1>H新增會員失敗</h1>
        <ul>
            <%
                List<String> errors = (List<String>) request.getAttribute("errors");
                for (String error : errors) {
            %>
            <li><%= error%></li>
                <%
                    }
                %>
        </ul>
        <a href="register.html">返回註冊頁面</a>
    </body>
</html>
