<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Index JSP</title>
    </head>
    <body>
        <h1>Add Student</h1>
        <form action="/student/add" method="post">
            <label>Name</label>
            <input type="text" name="name">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
