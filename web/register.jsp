<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<html>
<head>
    <title>Register</title>
    <%@include file="links.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
    <br>
    <div class="row mt-3">
        <div class="col-6 mx-auto">
            <form action="/register" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input name="username" type="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Repeat Password</label>
                    <input name="repeatPassword" type="password" class="form-control" id="exampleInputPassword2">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Full Name</label>
                    <input name="fulName" type="text" class="form-control" id="exampleInputPassword3">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Role Id</label>
                    <input name="roleId" type="number" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-danger">Submit</button>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>