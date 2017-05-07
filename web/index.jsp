<%-- 
    Document   : index
    Created on : 2017/5/7, 下午 06:26:30
    Author     : sinsnn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>成果</title>
    </head>
    <body>
        <div>
            <a href='register.jsp'>還不是會員</a>
            <p></p>
            <div>${ requestScope.error }</div>
            <form action="login.do" method="POST">
                <table border="1" >
                    <thead>
                        <tr>
                            <th colspan="2">登入</th>                    
                        </tr> 

                    </thead>
                    <tbody>
                        <tr>
                            <td>名稱：</td>
                            <td><input type="text" name="username" value="${param.username}" /></td>
                        </tr>
                        <tr>
                            <td>密碼：</td>
                            <td><input type="password" name="password"  /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="登入" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan='2'><a href='forgot.html'>忘記密碼？</a>
                            </td>
                        </tr>
                    </tbody>
                </table>                
            </form>

        </div>
    </body>
</html>
