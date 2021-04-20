<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 17/04/2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddImcomeMoney</title>
</head>
<%@ include file="header.jsp" %>
<body>
<h1>DODAJ PRZYCHÓD</h1>
<form:form method="POST" modelAttribute="Expenses"  class="padding-small text-center">
<div class="form-group">
    <div class="form-group">
        <input type="text" class="form-control" id="incomeMoney" name="incomeMoney" placeholder="wpis kwotę">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="description" name="description" placeholder="opis może mieć 150 znaków">
    </div>
    <button class="btn btn-color rounded-0" type="submit">Dodaj następny</button>
    </form:form>

</body>
</html>
