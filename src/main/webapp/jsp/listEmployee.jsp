<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title></title>

</head>
<body>
<h1>List Employee</h1>
<h2>Department: <c:out value="${department_id}"/></h2>
<table border="1">
    <thead>
    <tr>
        <th>ID:</th>
        <th>Name:</th>
        <th>Email:</th>
        <th>Born day:</th>
        <th>Salary</th>
        <th>id Dept:</th>
        <th>Delete:</th>
        <th>Edit:</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${emp}">
        <tr>
            <td><c:out value="${emp.id}" /></td>
            <td><c:out value="${emp.name}"></c:out>
            <td><c:out value="${emp.email}" /></td>
            <td><c:out value="${emp.date}" /></td>
            <td><c:out value="${emp.salary}"></c:out>
            <td><c:out value="${department_id}" /></td>
            <td>
                <form method="POST" action="/deleteEmployee">
                    <input type="submit" name="deleteForm" value="Delete Employee"> <input type="hidden" name="delete" value="${emp.id}">
                </form>
            </td>
            <td><input type=button onClick="location.href='/addEmployee?employees_id=<c:out value="${emp.id}" />'" value='Update'></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<input type=button onClick="location.href='/addEmployee?department_id=<c:out value="${department_id}"/>'" value='Add Employee'>
</body>
</html>