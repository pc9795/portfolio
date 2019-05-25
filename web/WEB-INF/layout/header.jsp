<%--
User: Prashant Chaubey
Date: 08-09-2018
Time: 23:37
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/" var="home"/>
<c:url value="/work" var="work"/>
<c:url value="/blog" var="blog"/>
<c:url value="/lists" var="lists"/>
<c:url value="/contact" var="contact"/>
<div class="container">
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a id="home_link" class="navbar-brand" href="${home}">Prashant Chaubey</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
                <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                                <a class="nav-link" href="${blog}">Blog</a>
                        </li>
                        <li class="nav-item">
                                <a class="nav-link" href="${work}">Work</a>
                        </li>
                         <li class="nav-item">
                                <a class="nav-link" href="${lists}">Lists</a>
                        </li>
                        <li class="nav-item">
                                <a class="nav-link" href="${contact}">Contact</a>
                        </li>
                </ul>
        </div>
</nav>
</div>