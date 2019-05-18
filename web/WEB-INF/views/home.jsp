<%--
   Home page
  User: Prashant Chaubey
  Date: 01-09-2018
  Time: 02:36
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/work" var="work"/>
<c:url value="/lists" var="lists"/>
<c:url value="/blog" var="blog"/>
<c:url value="/tutorial" var="tutorial"/>
<div class="container">
    <div class="row card-deck">
        <div class="col-md-4 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">What I am good at?</h4>
                    <p class="card-text">
                        A language agnostic software developer who worked on a myriad of programming languages such as
                        Java, Python, JavaScript and GO. In the past I built web and desktop applications and worked on
                        areas like automatic code generation. Currently I build distributed RPA systems
                    </p>
                </div>
                <div class="card-footer">
                    <a class="text-secondary" href='${work}'>See more of my work</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Current reading list of books</h4>
                    <p class="card-text">I prefer traditional way of learning through books and like to maintain a list.</p>
                </div>
                <div class="card-footer">
                    <a href="${lists}" class="text-secondary">Reading List</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Video-games</h4>
                    <p class="card-text">Care to check which games I play :p</p>
                </div>
                <div class="card-footer">
                    <a href="${lists}" class="text-secondary">Gaming List</a>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <div class="row card-deck">
        <div class="col-4"><h3>Work Samples/Personal Projects</h3></div>
        <div class="col-8"><a href="${work}" class="text-secondary pull-right">See more of my work</a></div>
        <div class="col-md-4 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Portfolio website/Blog</h4>
                    <p class="card-text">This website runs on Spring and Hibernate in the Backend, and JQuery and
                        Bootstrap
                        is used for UI</p>
                </div>
            </div>
        </div>
        <c:forEach items="${workItems}" var="work_item">
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">
                                ${work_item.heading}
                        </h4>
                        <p class="card-text">
                                ${work_item.description}
                        </p>
                    </div>
                    <div class="card-footer">

                        <a href='<c:choose>
                                        <c:when test="${work_item.link}">
                                            ${work_item.link}
                                        </c:when>
                                        <c:otherwise>
                                            #
                                        </c:otherwise>
                                     </c:choose>' class="text-secondary">Github Link</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <hr>
    <div class="row card-deck">
        <div class="col-4"><h3>Recent articles from the blog</h3></div>
        <div class="col-8"><a href="${blog}" class="text-secondary pull-right">All articles</a></div>
        <c:forEach items="${blogItems}" var="blog_item">
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${blog_item.heading}</h4>
                        <p class="card-text">${blog_item.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <hr>
    <div class="row card-deck">
        <div class="col-4"><h3>Recent tutorials</h3></div>
        <div class="col-8"><a href="${tutorial}" class="text-secondary pull-right">All tutorials</a></div>
        <c:forEach items="${tutorialItems}" var="tutorial_item">
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${tutorial_item.heading}</h4>
                        <p class="card-text">${tutorial_item.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>