<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${locale}" /> <!-- setLocale must in front of setBundle -->
<fmt:setBundle basename="i18n/webPage" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

    <h2><fmt:message key="user.userManagement" /></h2>
    <hr><br>

    <!-- select Languages -->
    <div style="float:right;position: absolute; top:10px; right: 30px;">
        <fmt:message key="languages"/>:
        <a href="/getAll?locale=en"><fmt:message key="language.english"/></a> | <a href="/getAll?locale=zh_CN"><fmt:message key="language.chinese"/></a>
    </div>

    <!-- Add from -->
    <form action="/add">
        id: <input name="id"/>  name: <input name="name"/> <input type="hidden" name="locale" value="${locale}"/>
        <input type="submit" value="<fmt:message key="user.add" />" />
    </form>
    <br/>

    <!-- remove form -->
    <form action="/remove">
        id: <input name="userId"/>  <input type="hidden" name="locale" value="${locale}"/>
        <input type="submit" value="<fmt:message key="user.remove" />" />
    </form>
    <br/>

    <!-- list table -->
    <h3><fmt:message key="user.list" /></h3>
    <table border="1" >
        <tr>
            <th width="150px"><fmt:message key="user.id" /></th>
            <th width="150px"><fmt:message key="user.name" /></th>
        </tr>
        <c:forEach var="myUser" items="${userList}" >
        <tr>
            <td> <c:out value="${myUser.id}"/></td>
            <td> <c:out value="${myUser.name}"/> </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
