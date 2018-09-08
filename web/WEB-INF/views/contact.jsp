<%--
  Page with which a user can contact me.
  User: Prashant Chaubey
  Date: 01-09-2018
  Time: 01:02
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact me</title>
    <c:url var="resume_link" value="/resume"></c:url>
</head>
<body>
<%--@elvariable id="contactForm" type="com.prashantchaubey9795.entities.ContactForm"--%>
<sf:form method="post" commandName="contactForm">
    <sf:label path="name">Name:</sf:label><sf:input path="name"/><br>
    <sf:label path="contact">Contact:</sf:label><sf:input path="contact"/><br>
    <sf:label path="email">Email:</sf:label><sf:input path="email"/><br>
    <sf:label path="purpose">Purpose:</sf:label><sf:textarea path="purpose"/><br>
    <input type="submit" value="Say Hello!"/>
    <sf:errors path="*" element="div"/>
</sf:form>
<a href="${resume_link}">See my Resume</a>
<c:if test="${success}">
    Details submitted successfully!
</c:if>
</body>
</html>
