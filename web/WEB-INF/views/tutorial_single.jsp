<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 16:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${tutorialItem.heading}</title>
</head>
<body>
<h1>${tutorialItem.heading}</h1>
<label>Description:</label>
<p>${tutorialItem.description}</p>
<label>Tags</label>
<p>${tutorialItem.tutorialTags}</p>
<label>Content</label>
<p>${tutorialItem.content}</p>
<label>Timestamp</label>
<p>${tutorialItem.timestamp}</p>
</body>
</html>
