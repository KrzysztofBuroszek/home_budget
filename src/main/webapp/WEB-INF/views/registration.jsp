<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 06/04/2021
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<h1>REJESTRACJA</h1>

<form:form method="post" modelAttribute="Users"  class="padding-small text-center" >
    <div class="form-group">
        <form:errors path="*"/>


        <input type="text" class="form-control" id="name" name="name" placeholder="podaj imię">
        <form:errors path="name"/><br/>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="nick" name="nick" placeholder="nick">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="mail" name="mail" placeholder="podaj email">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="password" name="password" placeholder="podaj hasło">
    </div>
<%--    <div class="form-group">--%>
<%--        <input type="text" class="form-control" id="repassword" name="repassword" placeholder="powtórz hasło">--%>
<%--    </div>--%>
    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
</form:form>

</body>
</html>
