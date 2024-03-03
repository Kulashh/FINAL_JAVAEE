package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;

import java.io.IOException;

@WebServlet(value = "/newsDetails")
public class NewsDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        News news = DBManager.getNewsById(Long.parseLong(id));
        req.setAttribute("newsDetails", news);
        req.getRequestDispatcher("newsdetails.jsp").forward(req, resp);
    }
}