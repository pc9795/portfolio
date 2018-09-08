<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 17:25
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work</title>
</head>
<body>
<ul>
    <c:forEach items="${workItems}" var="workItem">
        <li>${workItem}</li>
    </c:forEach>
</ul>
</body>
</html>
