package model;

import java.sql.Timestamp;

public class Comments {
    private Long id;
    private String comments;
    private Timestamp postDate;
    private User user;
    private News news;
    public Comments(){

    }
    public Comments(Long id, String comments, Timestamp postDate, User user, News news) {
        this.id = id;
        this.comments = comments;
        this.postDate = postDate;
        this.user = user;
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
