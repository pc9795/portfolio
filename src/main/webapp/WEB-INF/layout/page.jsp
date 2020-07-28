<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 23:37
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tx" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url value="/node_modules/bootstrap/dist/css/bootstrap.min.css" var="bootstrap"/>
<c:url value="/node_modules/font-awesome/css/font-awesome.min.css" var="font_awesome"/>
<c:url value="/resources/css/page.css" var="custom_css"/>
<c:url value="/node_modules/jquery/dist/jquery.min.js" var="jquery"/>
<c:url value="/node_modules/bootstrap/dist/js/bootstrap.min.js" var="bootstrap_js"/>
<c:url value="/resources/js/utils.js" var="utils"/>
<c:url value="/resources/favicon-16x16.png" var="favicon"/>
<tx:useAttribute name="javascripts" id="js_list" classname="java.util.List"/>
<tx:useAttribute name="stylesheets" id="css_list" classname="java.util.List"/>
<html>
<head>
    <link rel="icon" type="image/png" href="${favicon}" sizes="16x16" />
    <title><t:insertAttribute name="title"/></title>
    <meta charset="UTF-8">
    <meta name="description" content="Personal website of Prashant Chaubey. Contains links for Prashant
    Chaubey's resume and work samples. Also has a blog for Coding, Guitar, Weight loss, Diet plans and GRE preparation.
    This website contains some coding tutorials also.">
    <meta name="keywords" content="Prashant Chaubey, Personal website, Resume, Work samples, Coding Blog, Coding Tutorials,
    Diet Plans, Guitar Tutorials, Weight loss, GRE prep">
    <meta name="author" content="Prashant Chaubey">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${bootstrap}"/>
    <link rel="stylesheet" type="text/css" href="${font_awesome}"/>
    <link rel="stylesheet" type="text/css" href="${custom_css}">
    <!-- stylesheets -->
    <c:forEach var="css" items="${css_list}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <!-- end stylesheets -->
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
    <script type="text/javascript" src="${utils}"></script>
    <!-- scripts -->
    <c:forEach var="script" items="${js_list}">
        <script src="<c:url value="${script}"/>"></script>
    </c:forEach>
    <!-- end scripts -->
</body>
</html>
