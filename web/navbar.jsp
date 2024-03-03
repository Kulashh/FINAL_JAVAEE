<%@ page import="model.User" %><%
    User user = (User) request.getSession().getAttribute("ONLINE_USER");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">BITLAB NEWS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <% if (user != null) { %>
                <li class="nav-item">
                    <a class="nav-link" href="#"><%= user.getFulName() %>
                    </a>
                </li>
                </li>
                <% if ("1".equals(user.getRoleId())) { %>
                <li class="nav-item">
                    <a class="nav-link" href="/addNews">Add News</a>

                    <% } else if ("2".equals(user.getRoleId())) { %>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/viewNews">View News</a>
                </li>
                <% } %>
                <% } else { %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/login">Sign in</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/register">Sign up</a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>