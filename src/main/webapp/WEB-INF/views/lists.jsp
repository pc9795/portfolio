<%--
  Lists page
  User: Prashant Chaubey
  Date: 02-09-2018
  Time: 03:56
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div class="row mt-3">
        <div class="col-md-6 col-sm-12">
            <h3>Casual Readings <i class="fa fa-frown-o" aria-hidden="true"></i></h3>
            <ul>
                <c:forEach items="${casualReadingList}" var="book">
                    <li>${book.name} <span class="text-secondary">completed on ${book.date}</span></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-md-6 col-sm-12">
            <h3>Technical Readings <i class="fa fa-meh-o" aria-hidden="true"></i></h3>
            <c:forEach items="${technicalReadingList}" var="book">
                <li>${book.name} <span class="text-secondary">completed on ${book.date}</span></li>
            </c:forEach>
        </div>
        <div class="col-md-6 col-sm-12">
            <h3>Video Games <i class="fa fa-smile-o" aria-hidden="true"></i></h3>
            <c:forEach items="${gamingReadingList}" var="book">
                <li>${book.name} <span class="text-secondary">completed on ${book.date}</span></li>
            </c:forEach>
        </div>
    </div>
</div>
