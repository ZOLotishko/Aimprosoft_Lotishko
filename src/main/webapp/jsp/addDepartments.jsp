<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>New Department</title>
    <link href="<c:url value="style.css"/>" rel="stylesheet" type="text/css">
</head>

<body>
<center>
    <form method="POST" action="showAddList">
        <h2>  Department</h2>
        <table>
            <tr>
                <td><input type="text" readonly name="id" id="id" value="<c:out value="${department.id}" />" /></td>
            </tr>
            <tr>
                <td><label for="name">Name</label></td>
            </tr>
            <tr>
                <td><input type="text" name="name" id="name" value="<c:out value="${department.name}" />" />
                    <span class="error"><c:out value="${error.name}"/></span></td>
            </tr>

        </table>
        <input type="submit" value="add">
        <a class="btn btn-default" href="?action=backButton">Back to department list</a>

    </form>
</center>
</body>
</html>