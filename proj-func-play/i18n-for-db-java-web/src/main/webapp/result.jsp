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
    <meta http-equiv="Refresh" content="1;url=/getAll?locale=${locale}">
</head>
<body>

    <h3>${message}</h3>
    <%--<% response.setHeader("refresh", "2;URL=/getAll"); %>--%>

</body>
</html>
