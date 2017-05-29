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
        <div>
            <c:if test="${requestScope.errors != null}">
            <h1>新增鄉鎮村里清單失敗</h1>
            <ul>
                <c:forEach var="error" items="${requestScope.errors}">
                    <li>
                        ${error}
                    </li>
                </c:forEach>
            </ul>

        </c:if>
        </div>
        <div>
            <form action="townVillageListAdd.do" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th colspan="2">新增鄉鎮市村里清單</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>鄉鎮市</td>
                            <td><input type="text" name="townname" value="${param.townname}" /></td>
                        </tr>
                        <tr>
                            <td>村里</td>
                            <td><input type="text" name="villagename" value="${param.villagename}" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="新增" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>     
        </div>
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
                        <td>
                            <a href="townVillageListModifyPrep.do?num=${townVillageList.num}">修改</a>
                        </td>
                        <td>
                            <a href="townVillageListDelete.do?num=${townVillageList.num}">刪除</a>
                        </td>
                    </tr> 
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
