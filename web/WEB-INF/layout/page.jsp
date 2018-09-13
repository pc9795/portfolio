<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 23:37
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><t:insertAttribute name="title"/></title>
    <link  rel="stylesheet" type="text/css" href="/node_modules/bootstrap/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/node_modules/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/page.css">
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
    <script type="text/javascript" src="/node_modules/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <%--<script type="text/javascript" src="/resources/js/page.js"></script>--%>
</body>
</html>
