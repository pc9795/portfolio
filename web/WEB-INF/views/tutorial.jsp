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
    <div class="row">
        <div class="col-12">
            <h1>Blog</h1>
        </div>
        <div class="col-md-8 col-sm-12">
            <c:forEach items="${tutorialItems}" var="tutorial_item">
                <div class="row mt-3">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h3>${tutorial_item.heading}</h3>
                                <p>
                                    Created on: ${tutorial_item.timestamp}
                                    <c:forEach items="${tutorial_item.tutorialTags}" var="tutorial_tag">
                                        <a href="${tutorial_by_tag}${tutorial_tag.id}"
                                           class="badge badge-secondary pull-right mx-1">${tutorial_tag.name}</a>
                                    </c:forEach>
                                </p>
                                <p>
                                        ${tutorial_item.description}
                                </p>
                                <a class="btn btn-secondary" href="${tutorial_single}${tutorial_item.id}">Read more</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="row ">
                <div class="col-12 mt-3">
                    <form action="${tutorial_by_search}">
                        <div class="form row">
                            <div class="col-8">
                                <input name="search_text" class="form-control" type="text"/>
                            </div>
                            <div class="col-4">
                                <button class="btn btn-secondary" type="submit">Search</button>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="col-12 mt-3">
                    <h2>Tags</h2>
                    <c:forEach items="${tutorialTags}" var="tutorial_tag">
                        <a href="${tutorial_by_tag}${tutorial_tag.id}"
                           class="badge badge-secondary mx-1">${tutorial_tag.name}</a>
                    </c:forEach>
                </div>

                <div class="col-12 mt-3">
                    <h2>Archives</h2>
                    <ul>
                        <li><a class="text-secondary" href="${tutorial_by_year}2017">2017</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}JAN_2018">January 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}FEB_2018">Feburary 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}MAR_2018">March 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}APR_2018">April 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}MAY_2018">May 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}JUN_2018">June 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}JUL_2018">July 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}AUG_2018">Auguest 2018</a></li>
                        <li><a class="text-secondary" href="${tutorial_by_month}SEP_2018">September 2018</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>