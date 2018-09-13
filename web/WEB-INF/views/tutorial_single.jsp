<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 16:37
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/tutorial/tag/" var="tutorial_by_tag"/>
<div class="container">
    <div class="row">
        <div class="col-12 mt-3">
            <h1>${tutorialItem.heading}</h1>
        </div>
        <div class="col-12 mt-3">
            <p>Created on: ${tutorialItem.timestamp}
                <c:forEach items="${tutorialItem.tutorialTags}" var="tutorial_tag">
                    <a href="${tutorial_by_tag}${tutorial_tag.id}"
                       class="badge badge-secondary pull-right mx-1">${tutorial_tag.name}</a>
                </c:forEach></p>
        </div>
        <div class="col-12">
            ${tutorialItem.content}
        </div>
    </div>
</div>