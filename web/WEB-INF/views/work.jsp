<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 17:25
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<ul>
    <c:forEach items="${workItems}" var="workItem">
        <li>${workItem}</li>
    </c:forEach>
</ul>
</div>