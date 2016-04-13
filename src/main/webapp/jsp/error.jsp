<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="<c:url value="/css/materialize.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <div>
        <h1> Error</h1>
        <h1 style="text-align: center"><c:out value="${error}"/></h1>
        <a href="/">Return home page!</a>
    </div>
</div>
</body>
</html>