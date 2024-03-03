package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comments;
import model.News;
import model.User;

import java.io.IOException;

@WebServlet(value = "/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commentText = req.getParameter("commentText");
        String newsId = req.getParameter("newsId");
        User user = (User) req.getSession().getAttribute("ONLINE_USER");
        News news = DBManager.getNewsById(Long.parseLong(newsId));
        Comments comment = new Comments();
        comment.setComments(commentText);
        comment.setNews(news);
        comment.setUser(user);
        DBManager.addComment(comment);
        resp.sendRedirect("/home");
    }
}