<%--
  Page with which a user can contact me.
  User: Prashant Chaubey
  Date: 01-09-2018
  Time: 01:02
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="resume_link" value="/resume"/>
<div class="container">
<%--@elvariable id="contactForm" type="com.prashantchaubey9795.entities.ContactForm"--%>
<div class="row ">
    <div class="col-sm-12 mt-3 col-md-4 p-1">
        <sf:form method="post" commandName="contactForm">
            <c:if test="${success}">
                Details submitted successfully!
            </c:if>
            <sf:errors path="*" element="div"/>
            <div class="form-group row">
                <sf:label cssClass="col-3 col-form-label" path="name">Name:</sf:label>
                <div class="col-9">
                    <sf:input cssClass="form-control" path="name"/>
                    <small class="form-text text-muted">How should I address you <i class="fa fa-question"> </i></small>
                </div>
            </div>
            <div class="form-group row">
                <sf:label cssClass="col-3 col-form-label" path="contact">Contact:</sf:label>
                <div class="col-9">
                    <sf:input cssClass="form-control" path="contact"/>
                    <small class="form-text text-muted">I will keep it safely <i class="fa fa-smile-o"></i></small>
                </div>
            </div>
            <div class="form-group row">
                <sf:label cssClass="col-3 col-form-label" path="email">Email:</sf:label>
                <div class="col-9">
                    <sf:input cssClass="form-control" path="email"/>
                    <small class="form-text text-muted">No spams I promise <i class="fa fa-hand-peace-o"></i></small>
                </div>
            </div>
            <div class="form-group row">
                <sf:label cssClass="col-3 col-form-label" path="purpose">Purpose:</sf:label>
                <div class="col-9">
                    <sf:textarea rows="3" cssClass="form-control" path="purpose"/>
                    <small class="form-text text-muted">How can I help your <i class="fa fa-question"> </i></small>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Say Hello!</button>
        </sf:form>
        <div class="row">
            <div class="col-12">
                <a class="btn btn-info" href="${resume_link}">See My Resume</a>
            </div>
        </div>
    </div>
    <div class="col-sm-12 mt-3 col-md-8">
        <div class="row">
            <div class="col-12 text-right">
                <div class="mapouter">
                    <div class="gmap_canvas">
                        <iframe width="600" height="500" id="gmap_canvas"
                                src="https://maps.google.com/maps?q=electronic%20city&t=&z=13&ie=UTF8&iwloc=&output=embed"
                                frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
                        </iframe>

                    </div>
                    <style>
                        .gmap_canvas {
                            overflow:auto;
                            background:none!important;
                        }
                    </style>
                </div>
            </div>
            <div class="col-12 text-center">
                <p class="text-right">I live here <i class="fa fa-hand-o-up"></i></p>
            </div>
        </div>

    </div>
</div>
</div>