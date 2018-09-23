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
        <div class="col-12 mt-3">
            <h3 style="color: red;">Quick Peek <i class="fa fa-eye"></i> <i class="fa fa-eye"></i></h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 bg-light col-sm-12">
            <div class="text-center">
                <img src="${profile}" class="mt-3 text-center img-fluid" alt="profile photo"/>
            </div>

            <p class="mt-3"><span class="font-weight-bold">Experience:</span> 2 Years</p>
            <p><span class="font-weight-bold">Employed in:</span> Software Robotics Cooperation Ltd</p>
            <p><span class="font-weight-bold">Role:</span> Software Engineer</p>
            <P><span class="font-weight-bold">Skills:</span> Java8, Python3, NodeJS </P>
        </div>
        <div class="col-md-8 col-sm-12">
            <h4 class="mt-3">Role Description</h4>
            <p>Devloping desktop application using Python and Electron.</p>
            <h4>Certifications</h4>
            <ul>
                <li>Codechef's Data Structures and Algorithms - Foundation</li>
                <li>Oracle Certified Associate Java Programmer</li>
                <li>Alogorithms Specialization - Coursera</li>
            </ul>
            <h4>Education</h4>
            <li>BTech, Japyee Institute of Information Technology, CGPA: 8.9, (2016)</li>
            <li>Intermediate, Kendriya Vidhyalaya, 88.6%, (2012)</li>
        </div>
    </div>
</div>