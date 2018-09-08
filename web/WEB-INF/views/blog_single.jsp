<%--
  User: Prashant Chaubey
  Date: 08-09-2018
  Time: 16:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${blogItem.heading}</title>
</head>
<body>
<h1>${blogItem.heading}</h1>
<label>Description:</label>
<p>${blogItem.description}</p>
<label>Tags</label>
<p>${blogItem.blogTags}</p>
<label>Content</label>
<p>${blogItem.content}</p>
<label>Timestamp</label>
<p>${blogItem.timestamp}</p>
</body>
</html>
