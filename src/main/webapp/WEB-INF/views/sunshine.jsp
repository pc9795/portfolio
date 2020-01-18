<%--
  User: Prashant Chaubey
  Date: 09-12-2018
  Time: 11:19
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/node_modules/bootstrap/dist/css/bootstrap.min.css" var="bootstrap"/>
<c:url value="/node_modules/jquery/dist/jquery.min.js" var="jquery"/>
<c:url value="/node_modules/bootstrap/dist/js/bootstrap.min.js" var="bootstrap_js"/>
<c:url value="/resources/js/sunshine.js" var="custom_js"/>
<c:url value="/resources/css/sunshine.css" var="custom_css"/>
<html>
    <head>
        <title>Happy Birthday Sunshine</title>
        <link rel="shortcut icon" type="image/x-icon"
              href='<c:url value="/resources/img/favicon-16x16.png"/>'/>
        <link rel="stylesheet" type="text/css" href="${bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${custom_css}"/>
    </head>
    <body>
        <div class="container">
            <div id="hb_div" class="row mt-3">
                <div class="col-12 text-center">
                    <h1>Happy Birthday Sheenam :)</h1>
                </div>
            </div>
            <div class="row mt-5 b">
                <div class="col-12 col-sm-3 b mt-3">
                    <img alt="It should be a cake" class="img-fluid b"
                         src='<c:url value="/resources/img/cake.png"/>'>
                </div>
                <div class="col-12 col-sm-6 b text-center mt-3">
                    <button id="start" class="btn btn-info b">
                        This is what I feel for you.<br>I don't know whether<br>I can
                        pen it down properly<br> or not, but I want to try<br><br>PRESS
                        IT!!!
                    </button>

                    <p id="poem" hidden="hidden">
                        <span class="firstWord">H</span>ow strange it is?<br> <span
                        class="firstWord">A</span>nd I never thought it would ever happen<br>
                        <span class="firstWord">P</span>erson of my dreams<br> <span
                        class="firstWord">P</span>erson with whom I wish to be with<br>
                        <span class="firstWord">Y</span>oung like a newly formed river<br>
                        <span class="space" hidden="hidden"><br></span> <span
                        class="firstWord">B</span>eautiful as the heavenly night sky<br>
                        <span class="firstWord">I</span>rresistible she is<br> <span
                        class="firstWord">R</span>adiant like daylight<br> <span
                        class="firstWord">T</span>hat person will become a part of my life<br>
                        <span class="firstWord">H</span>ow strange it is?<br> <span
                        class="firstWord">D</span>eep inside my heart<br> <span
                        class="firstWord">A</span> feeling was there <br> <span
                        class="firstWord">Y</span>et I never expressed <br> <span
                        class="space" hidden="hidden"><br></span> <span
                        class="firstWord">S</span>urrounded by fears and anxieties<br>
                        <span class="firstWord">H</span>opes were not able to breed<br>
                        <span class="firstWord">E</span>ither it was luck or destiny<br>
                        <span class="firstWord">E</span>ither it was fluke or coincidence<br>
                        <span class="firstWord">N</span>ow I am with that person<br> <span
                        class="firstWord">A</span>nd I will never leave her<br> <span
                        class="firstWord">M</span>y sunshine :) <span class="space"
                                                                      hidden="hidden"><br></span>
                    </p>
                    <button id="show" class="btn btn-info b"
                            hidden="hidden">
                        If you read it<br>PRESS IT!!!
                    </button>

                </div>
                <div class="col-12 	col-sm-3 b mt-3">
                    <img alt="25 year old diva" class="img-fluid b"
                         src='<c:url value="/resources/img/25.png"/>'>
                </div>
            </div>

        </div>
        <script type="text/javascript"
                src='${jquery}'></script>
        <script type="text/javascript"
                src='${bootstrap_js}'></script>
        <script type="text/javascript"
                src='${custom_js}'></script>
    </body>
</html>

