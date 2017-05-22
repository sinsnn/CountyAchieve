<%-- 
    Document   : member
    Created on : 2017/5/7, 下午 12:32:12
    Author     : sinsnn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>會員登入成功</title>
    </head>
    <body>
        <h1>會員${sessionScope.login}您好</h1>
        <a href='logout.do?username=${sessionScope.login}'>登出${sessionScope.login} </a>
        <table border="1">
            <thead>
                <tr>
                    <th>編號</th>
                    <th>鄉鎮市</th>
                    <th>村里</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="townVillageList" items="${requestScope.townVillageLists}">
                    <tr>
                        <td>${townVillageList.num}</td>
                        <td>${townVillageList.townName}</td>
                        <td>${townVillageList.villageName}</td>              
                    </tr> 
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
