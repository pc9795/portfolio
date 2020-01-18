<%--
  User: Prashant Chaubey
  Date: 02-09-2018
  Time: 04:20
--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/blog/month/" var="blog_by_month"/>
<c:url value="/blog/tag/" var="blog_by_tag"/>
<c:url value="/blog/year/" var="blog_by_year"/>
<c:url value="/blog/search/" var="blog_by_search"/>
<c:url value="/blog/single/" var="blog_single"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-sm-12">
            <c:forEach items="${blogItems}" var="blog_item">
                <div class="row mt-3">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h3>${blog_item.heading}</h3>
                                <p class="font-italic">
                                    Created on: <fmt:formatDate type = "date"
                                                               value = "${blog_item.timestamp}" />
                                    <c:forEach items="${blog_item.blogTags}" var="blogtag">
                                        <a href="${blog_by_tag}${blogtag.id}"
                                           class="badge badge-secondary pull-right mx-1">${blogtag.name}</a>
                                    </c:forEach>
                                </p>
                                <p>
                                        ${blog_item.description}
                                </p>
                                <a class="btn btn-secondary" href="${blog_single}${blog_item.id}">Read more</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="row ">
                <div class="col-12 mt-3">
                    <form action="${blog_by_search}">
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
                    <c:forEach items="${blogTags}" var="blog_tag">
                        <a href="${blog_by_tag}${blog_tag.id}"
                           class="badge badge-secondary mx-1">${blog_tag.name}</a>
                    </c:forEach>
                </div>

                <div class="col-12 mt-3">
                    <h2>Archives</h2>
                    <ul>
                        <li><a class="text-secondary" href="${blog_by_year}2018">2018</a></li>
                        <li><a class="text-secondary" href="${blog_by_month}JAN_2019">January 2019</a></li>
                        <li><a class="text-secondary" href="${blog_by_month}FEB_2019">Feburary 2019</a></li>
                        <li><a class="text-secondary" href="${blog_by_month}MAR_2019">March 2019</a></li>
                        <li><a class="text-secondary" href="${blog_by_month}APR_2019">April 2019</a></li>
                        <li><a class="text-secondary" href="${blog_by_month}MAY_2019">May 2019</a></li>
                        <%--<li><a class="text-secondary" href="${blog_by_month}JUN_2019">June 2018</a></li>--%>
                        <%--<li><a class="text-secondary" href="${blog_by_month}JUL_2019">July 2018</a></li>--%>
                        <%--<li><a class="text-secondary" href="${blog_by_month}AUG_2019">Auguest 2018</a></li>--%>
                        <%--<li><a class="text-secondary" href="${blog_by_month}SEP_2019">September 2018</a></li>--%>
                        <%--<li><a class="text-secondary" href="${blog_by_month}OCT_2019">October 2018</a></li>--%>
                        <%--<li><a class="text-secondary" href="${blog_by_month}NOV_2019">September 2018</a></li>--%>
                        <%--<li><a class="text-secondary" href="${blog_by_month}DEC_2019">September 2018</a></li>--%>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>