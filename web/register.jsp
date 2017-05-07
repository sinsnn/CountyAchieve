<%-- 
    Document   : register
    Created on : 2017/5/7, 下午 06:16:26
    Author     : sinsnn
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>註冊</title>
    </head>
    <body>
        <%
            List<String> errors = (List<String>) request.getAttribute("errors");
            if (errors != null) {
        %>
        <h1>新增會員失敗</h1>
        <ul style='color: rgb(255, 0, 0);'>
            <%
                for (String error : errors) {
            %>
            <li><%= error%></li>
                <%
                    }
                %>
        </ul><br>
        <%
            }
        %>
        <div>
            <h1>會員註冊</h1>
            <form action="register.do" method="POST">
                <table border="1">

                    <tbody>
                        <tr>
                            <td>郵件位址：</td>
                            <td><input type="text" name="email" value="${param.email}" size="25" maxlength="100"/></td>
                        </tr>
                        <tr>
                            <td>名稱（最大16字元）</td>
                            <td><input  type="text" name="username" value="${param.username}" size="25" maxlength="16"/></td>
                        </tr>
                        <tr>
                            <td>密碼（6到16字元）：</td>
                            <td><input type='password' name='password' size='25' maxlength='16'></td>
                        </tr>
                        <tr>
                            <td>確認密碼：</td>
                            <td><input type="password" name="confirmedPasswd" value="" size="25" maxlength="16"/></td>
                        </tr>
                        <tr>
                            <td colspan='2' align='center'><input type='submit' value='註冊'>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>
        </div>
    </body>
</html>
