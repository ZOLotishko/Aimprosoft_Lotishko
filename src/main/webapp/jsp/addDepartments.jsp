<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>New Department</title>
    <link href="/css/materialaze.css" rel="stylesheet">
</head>
<body>
<center>
    <form method="POST" action="/showAddList">
        <h2 class="card-panel teal lighten-2">Creating or updating   Department</h2>

        <div class="container">

            <div class="row">
                <div class="col s4 offset-s4">
                    <table class="striped">

                        <input type="hidden" name="id" value="${department.id}"/>
                        Name : <input type="text" name="name"  value="<c:out value="${param['name'] eq null ? department.name : param['name']}"/>"/></br>
                        <span class="error" style="color: crimson">${error.get("name")}</span></br>

                    </table>
                    <input  class="waves-effect waves-light btn" type="submit" value="add">
                </div>
            </div>

        </div>
    </form>
</center>
</body>
</html>