<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>New Department</title>
</head>

<body>
<center>
    <form method="POST" action="/showAddList">
        <h2>  Department</h2>
        <table>
            <h1>Creating or updating Department</h1>
            <input type="hidden" name="id" value="<c:out value="${department.id}"/>"/>
            Name : <input type="text" name="name"  value="<c:out value="${param['name'] eq null ? department.name : param['name']}"/>"/></br>
            <span class="error" style="color: crimson">${error.get("name")}</span></br>

        </table>
        <input type="submit" value="add">

    </form>
</center>
</body>
</html>