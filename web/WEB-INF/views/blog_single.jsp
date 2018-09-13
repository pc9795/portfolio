<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 16:37
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/blog/tag/" var="blog_by_tag"/>
<div class="container">
    <div class="row">
        <div class="col-12 mt-3">
            <h1>${blogItem.heading}</h1>
        </div>
        <div class="col-12 mt-3">
            <p>Created on: ${blogItem.timestamp}
                <c:forEach items="${blogItem.blogTags}" var="blog_tag">
                    <a href="${blog_by_tag}${blog_tag.id}"
                       class="badge badge-secondary pull-right mx-1">${blog_tag.name}</a>
                </c:forEach></p>
        </div>
        <div class="col-12">
            ${blogItem.content}
        </div>
    </div>
</div>