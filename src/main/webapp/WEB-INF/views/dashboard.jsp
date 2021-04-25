<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 17/04/2021
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
</head>
<body>
<%@ include file="header.jsp" %>
STRONA UŻYTKOWNIKA


<form:form method="post" modelAttribute="IncomeMoney">



<%--    <br>idUser: <form:textarea path="idUser" items="${idUser}"/><br>--%>
    <span>|ID|:<c:out value="${idUser}"/></span>
<%--    Przychody suma: <form:textarea path="incomeMoney" items="${incomeMoney}"/><br>--%>
<%--    Wydatki suma: <form:select path="expenses" items="${expenses}"/><br>--%>


   Przychody lista: <c:forEach items="${incomeMoney}" var="incomeMoney"><br>
        <p>${incomeMoney}</p>
    </c:forEach>

    Wydatki lista: <c:forEach items="${expenses}" var="expenses">
    <p>${expenses}</p>
</c:forEach>


</form:form>

</body>
</html>
