<%--
  User: Prashant Chaubey
  Date: 25-01-2020
  Time: 18:53
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url value="/resources/img/logo-elastic-search-color-64.svg" var="elastic_logo"/>
<c:url value="/blogs" var="blog"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-sm-12">
            <h4>${fn:length(blogItems)} results found for <span class="font-italic text-secondary">${search}</span></h4>
            <c:forEach items="${blogItems}" var="blog_item">
                <div class="row mt-3">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h3>${blog_item.heading}</h3>
                                <p>
                                        ${blog_item.description}
                                </p>
                                <a class="btn btn-secondary" href="${blog}/${blog_item.id}">Read more</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="row ">
                <div class="col-12 mt-3">
                    <form action="${blog}">
                        <div class="form row">
                            <div class="col-12">
                                <p><span class="text-muted">Powered by</span>
                                    <img src="${elastic_logo}"
                                         class="img-fluid"
                                         alt="elastic search logo"
                                         height="25"
                                         width="25"
                                    />
                                </p>
                            </div>
                            <div class="col-8">
                                <label>
                                    <input name="search" class="form-control" type="text"/>
                                </label>
                            </div>
                            <div class="col-4">
                                <button class="btn btn-secondary" type="submit">Search</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>