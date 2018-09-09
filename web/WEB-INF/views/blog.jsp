<%--
  User: Prashant Chaubey
  Date: 02-09-2018
  Time: 04:20
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/blog/month/" var="blog_by_month"/>
<c:url value="/blog/tag/" var="blog_by_tag"/>
<c:url value="/blog/year/" var="blog_by_year"/>
<c:url value="/blog/search/" var="blog_by_search"/>
<c:url value="/blog/single/" var="blog_single"/>
<div class="container">
<ul>
    <c:forEach items="${blogTags}" var="blog_tag">
        <li><a href="${blog_by_tag}${blog_tag.id}">${blog_tag}</a></li>
    </c:forEach>
</ul>
<hr>
<ul>
    <c:forEach items="${blogItems}" var="blog_item">
        <li><a href="${blog_single}${blog_item.id}">${blog_item}</a></li>
    </c:forEach>

</ul>
<hr>
<div>Archives</div>
<ul>
    <li><a href="${blog_by_year}2017">2017</a></li>
    <li><a href="${blog_by_month}JAN_2018">January 2018</a></li>
    <li><a href="${blog_by_month}FEB_2018">Feburary 2018</a></li>
    <li><a href="${blog_by_month}MAR_2018">March 2018</a></li>
    <li><a href="${blog_by_month}APR_2018">April 2018</a></li>
    <li><a href="${blog_by_month}MAY_2018">May 2018</a></li>
    <li><a href="${blog_by_month}JUN_2018">June 2018</a></li>
    <li><a href="${blog_by_month}JUL_2018">July 2018</a></li>
    <li><a href="${blog_by_month}AUG_2018">Auguest 2018</a></li>
    <li><a href="${blog_by_month}SEP_2018">September 2018</a></li>
</ul>
<hr>
<form action="${blog_by_search}">
    <input name="search_text" type="text"/><br>
    <button type="submit">Search</button>
</form>
</div>