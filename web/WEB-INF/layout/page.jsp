<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 23:37
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/node_modules/bootstrap/dist/css/bootstrap.min.css" var="bootstrap"/>
<c:url value="/node_modules/font-awesome/css/font-awesome.min.css" var="font_awesome"/>
<c:url value="/resources/css/page.css" var="custom_css"/>
<c:url value="/node_modules/jquery/dist/jquery.min.js" var="jquery"/>
<c:url value="/node_modules/bootstrap/dist/js/bootstrap.min.js" var="bootstrap_js"/>
<html>
<head>
    <title><t:insertAttribute name="title"/></title>
    <link  rel="stylesheet" type="text/css" href="${bootstrap}"/>
    <link rel="stylesheet" type="text/css" href="${font_awesome}"/>
    <link rel="stylesheet" type="text/css" href="${custom_css}">
</head>
<body>
    <div class="header">
        <t:insertAttribute name="header"/>
    </div>
    <div class="content mt-2 mb-2">
        <t:insertAttribute name="body"/>
    </div>
    <div class="footer">
        <t:insertAttribute name="footer"/>
    </div>
    <script type="text/javascript" src="${jquery}"></script>
    <script type="text/javascript" src="${bootstrap_js}"></script>
    <%--<script type="text/javascript" src="/resources/js/page.js"></script>--%>
</body>
</html>
