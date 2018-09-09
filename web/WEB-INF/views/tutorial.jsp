<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 15:38
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/tutorial/month/" var="tutorial_by_month"/>
<c:url value="/tutorial/tag/" var="tutorial_by_tag"/>
<c:url value="/tutorial/year/" var="tutorial_by_year"/>
<c:url value="/tutorial/search/" var="tutorial_by_search"/>
<c:url value="/tutorial/single/" var="tutorial_single"/>
<div class="container">
<ul>
    <c:forEach items="${tutorialTags}" var="tutorial_tag">
        <li><a href="${tutorial_by_tag}${tutorial_tag.id}">${tutorial_tag}</a></li>
    </c:forEach>
</ul>
<hr>
<ul>
    <c:forEach items="${tutorialItems}" var="tutorial_item">
        <li><a href="${tutorial_single}${tutorial_item.id}">${tutorial_item}</a></li>
    </c:forEach>

</ul>
<hr>
<div>Archives</div>
<ul>
    <li><a href="${tutorial_by_year}2017">2017</a></li>
    <li><a href="${tutorial_by_month}JAN_2018">January 2018</a></li>
    <li><a href="${tutorial_by_month}FEB_2018">Feburary 2018</a></li>
    <li><a href="${tutorial_by_month}MAR_2018">March 2018</a></li>
    <li><a href="${tutorial_by_month}APR_2018">April 2018</a></li>
    <li><a href="${tutorial_by_month}MAY_2018">May 2018</a></li>
    <li><a href="${tutorial_by_month}JUN_2018">June 2018</a></li>
    <li><a href="${tutorial_by_month}JUL_2018">July 2018</a></li>
    <li><a href="${tutorial_by_month}AUG_2018">Auguest 2018</a></li>
    <li><a href="${tutorial_by_month}SEP_2018">September 2018</a></li>
</ul>
<hr>
<form action="${tutorial_by_search}">
    <input name="search_text" type="text"/><br>
    <button type="submit">Search</button>
</form>
</div>