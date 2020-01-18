<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 17:25
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="resume_link" value="/resume"/>
<c:url value="/resources/profile.jpg" var="profile"/>
<div class="container">
    <div class="row">
        <div class="col-12 mt-3">
            <a class="btn btn-info" href="${resume_link}">Download Resume</a>
        </div>
    </div>
    <div class="row card-deck mt-3">
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
    <div class="row">
        <div class="col-md-4 bg-light col-sm-12">
            <div class="text-center">
                <img src="${profile}" class="mt-3 text-center img-fluid" alt="profile photo"/>
            </div>

            <p class="mt-3"><span class="font-weight-bold">Proficient Languages:</span> <i style="color:red"
                                                                                           class="fa fa-heart"
                                                                                           aria-hidden="true"></i> Java,
                Python </p>
            <p><span class="font-weight-bold">Familiar Languages:</span> SQL, Typescript, JavaScript, HTML, CSS</p>
            <p><span class="font-weight-bold">Proficient S.E. Technologies:</span> Spring, Akka, REST, Maven, Junit,
                SQLAlchamy, PyTest, Git</p>
            <p><span class="font-weight-bold">Familiar S.E Technologies:</span> Hibernate, Tornado, Electron, Django
                ,Flask, Angular, CI/CD, Docker, SOAP, jQuery, Bootstrap, Azure DevOps</p>
        </div>
        <div class="col-md-8 col-sm-12">
            <h4>Certifications <i class="fa fa-certificate" aria-hidden="true"></i></h4>
            <ul>
                <li>Codechef's Data Structures and Algorithms - Foundation</li>
                <li>Oracle Certified Associate Java Programmer</li>
                <li>Alogorithms Specialization - Coursera</li>
            </ul>
            <h4>Education <i class="fa fa-university" aria-hidden="true"></i></h4>
            <ul>
                <li>MS in CS University College Dublin, Ireland, 2020 (Expected)</li>
                <li>B-Tech in ECE, Japyee Institute of Information Technology, Noida, India, CGPA: 8.9, (2016)</li>
                <li>Intermediate, Kendriya Vidhyalaya, Unnao, India, 88.6%, (2012)</li>
            </ul>
            <h4>Work Ex <i class="fa fa-road" aria-hidden="true"></i></h4>
            <ul>
                <li>Software Engineer, Soroco India, (May 2019 - Aug 2019)</li>
                <li>Java Developer, Wipro technologies, (Aug 2016 - April 2018)</li>
            </ul>
        </div>
    </div>
</div>