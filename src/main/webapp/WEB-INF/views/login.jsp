<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 06/04/2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>LOGIN</h1>

<%@ include file="registration.jsp"%>

<form:form method="post" modelAttribute="Users"  class="padding-small text-center">
<div class="form-group">

    <div class="form-group">
        <input type="text" class="form-control" id="nick" name="nick" placeholder="nick">
    </div>


<%--        <p>--%>
<%--            nick: <form:input path="nick" id="nick" name="nick" />--%>
<%--&lt;%&ndash;            <form:errors path="nick" cssClass="error" />&ndash;%&gt;--%>
<%--        </p>--%>


    <div class="form-group">
        <input type="text" class="form-control" id="password" name="password" placeholder="hasło">
    </div>

    <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>

    </form:form>

</body>
</html>
