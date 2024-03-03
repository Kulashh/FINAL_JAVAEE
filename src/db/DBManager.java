package db;

import model.Comments;
import model.News;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/FinalJava03Database",
                    "postgres",
                    "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String email) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? ");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String fulName = resultSet.getString("fulName");
                String roleId = resultSet.getString("role_Id");
                user = new User();
                user.setFulName(fulName);
                user.setPassword(password);
                user.setId(id);
                user.setEmail(email);
                user.setRoleId(roleId);
            }
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void registerUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (email,password,fulName,role_Id) " +
                            "VALUES (?,?,?,?) ");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFulName());
            preparedStatement.setString(4, user.getRoleId());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addNews(News news) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO news (title,content,categoryId,postDate) " +
                            "VALUES (?,?,?,now()) ");
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setString(3, String.valueOf(news.getCategory()));
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<News> getAllNews() {
        List<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT news.id, news.title, news.content, news.postDate, users.fulName, newsCategories.name " +
                            "FROM news " +
                            "INNER JOIN newsCategories" +
                            "ON news.categoryId = newsCategories.id" +
                            "ORDER BY postDate DESC ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("content");
                Timestamp postdate = resultSet.getTimestamp("postdate");
                String userFulName = resultSet.getString("fulName");
                User user = new User();
                user.setFulName(userFulName);
                News news1 = new News();
                news1.setId(id);
                news1.setTitle(title);
                news1.setContent(text);
                news1.setPostDate(postdate);
                news.add(news1);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static News getNewsById(Long id) {
        News news = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT news.title, news.content, news.postdate, users.fulName, newsCategories.name " +
                    "FROM news " +
                    "INNER JOIN users" +
                    "ON news.userId = users.id" +
                    "INNER JOIN newsCategories " +
                    "ON news.categoryId = newsCategories.id " +
                    "WHERE news.id=? ");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String text = resultSet.getString("content");
                Timestamp postdate = resultSet.getTimestamp("postdate");
                String userFullName = resultSet.getString("fulName");
                User user = new User();
                user.setFulName(userFullName);
                news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContent(text);
                news.setPostDate(postdate);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void addComment(Comments comment) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO comments (comment,user_Id,news_Id,postDate) " +
                            "VALUES (?,?,?,now()) ");
            preparedStatement.setString(1, comment.getComments());
            preparedStatement.setString(2, String.valueOf(comment.getUser().getId()));
            preparedStatement.setString(3, String.valueOf(comment.getNews().getCategory()));
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
