<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>

    <h1>HOME</h1>

    <%@ include file="header.jsp" %>


    <a href="<c:out value="/registration"/>">Rejestracja</a><br>
    <a href="<c:out value="/login"/>">Logowanie</a>

    <%@ include file="footer.jsp" %>



