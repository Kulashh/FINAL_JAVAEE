<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 03.03.2024
  Time: 6:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.News" %>
<html>
<head>
    <title>News Details</title>
    <%@include file="links.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
    <br>
    <%
        News news = (News) request.getAttribute("newsDetails");
        if (news != null) {
    %>
    <div class="card w-75">
        <div class="card-body">
            <h5 class="card-title"><%=news.getTitle()%>
            </h5>
            <p class="card-text"><%=news.getContent()%>
            </p>
            <p><%=user.getFulName()%> </p>
            <p><%=news.getPostDate()%>
            </p>
            <br>
            <%
                if (user != null) {
            %>
            <form action="addComment" method="post">
                <input type="hidden" value="<%=news.getId()%>" name="newsId">
                <textarea class="form-control" name="commentText"></textarea>
                <br>
                <button class="btn btn-danger">SUBMIT</button>
            </form>
            <%}%>
        </div>
    </div>
    <%}%>
</div>
</body>
</html>
