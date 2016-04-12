<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>List Department</title>
    <link href="/css/materialaze.css" rel="stylesheet">
</head>
<body>
<h1 class="card-panel teal lighten-2" align="center">List Department</h1>

<div class="container">
    <table class="striped">
        <thead>
        <div class="row">
            <th>ID:</th>
            <th>Name:</th>
            <th>Edit:</th>
            <th>Delete:</th>
            <th>List Employee</th>
        </div>
        </thead>
        <tbody>
        <c:forEach var="dep" items="${dep}">
            <tr>
                <td><c:out value="${dep.id}" /></td>
                <td><c:out value="${dep.name}" /></td>

                <td><a href="/addDepartment?department_id=${dep.id}">Update</a></td>
                <td><a  href="/deleteDepartment?department_id=${dep.id}">Delete</a></td>
                <td><a  href="/listEmployees?department_id=${dep.id}">Show all employees</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form method="POST" action='addDepartment'>
        <input class="waves-effect waves-light btn" type="submit" value="Add Department">
    </form>
</div>
</body>
</html>