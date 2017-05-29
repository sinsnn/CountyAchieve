<%-- 
    Document   : townVillageListModify
    Created on : 2017/5/29, 下午 04:58:05
    Author     : sinsnn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改</title>
    </head>
    <body>
        <h1>修改鄉鎮村里清單!</h1>
        <div>
            <form action="townVillageListModify.do" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>編號</th>
                            <th>鄉鎮市</th>
                            <th>村里</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="num" value="${townVillageList.num}" readonly="readonly" />
                            <td>
                                <input type="text" name="townName" value="${townVillageList.townName}" />
                            </td>

                            <td>
                                <input type="text" name="villageName" value="${townVillageList.villageName}"/>
                            </td>
                            <td>
                                <input type="submit" value="修改" />
                            </td>
                            <td>
                                <a href="message.do">取消</a> 
                            </td>

                        </tr> 
                        

                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
