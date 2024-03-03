<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add News</title>
    <%@include file="links.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
    <br>
    <div class="row mt-3">
        <div class="col-6 mx-auto">
            <form action="/addNews" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">TITLE</label>
                    <input name="title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">CONTENT</label>
                    <textarea name="content" class="form-control"></textarea>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">CATEGORY ID</label>
                    <input name="categoryId" type="number" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp">
                </div>
                <button type="submit" class="btn btn-danger">ADD NEWS</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>