<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>List Department</title>
</head>
<body>
<h1 align="center">List Department</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID:</th>
        <th>Name:</th>
        <th>Edit:</th>
        <th>Delete:</th>
        <th>List Employee</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dep" items="${dep}">
        <tr>
            <td><c:out value="${dep.id}" /></td>
            <td><c:out value="${dep.name}" /></td>

            <td><a href="/addDepartment?department_id=${dep.id}">Update</a></td>
            <td><a href="/deleteDepartment?department_id=${dep.id}">Delete</a></td>
            <td><a href="/listEmployees?department_id=${dep.id}">Show all employees</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="POST" action='addDepartment'>
    <input type="submit" value="Add Department">
</form>
</body>
</html>