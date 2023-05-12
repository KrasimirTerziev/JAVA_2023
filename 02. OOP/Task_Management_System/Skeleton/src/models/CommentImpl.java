package models;

import models.interfaces.Comments;

import java.util.List;

public class CommentImpl implements Comments {
    private String author;

    private String content;
    private List<Comments> comments;

    public CommentImpl(String author, String content) {
        setAuthor(author);
        setContent(content);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getAsString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Author: " +author + "\n");
        sb.append("Content: " +content + "\n");
        return sb.toString();
    }
    public String toString(){
        return getAsString();
    }
}
