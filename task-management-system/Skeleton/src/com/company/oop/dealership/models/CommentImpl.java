package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

import static java.lang.String.format;

public class CommentImpl implements Comment {

    public static final int CONTENT_LEN_MIN = 3;
    public static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);
    public static CommentImpl comments;
    private String author;

    public CommentImpl(String content, String author){
        setContent(content);
        this.author = author;
    }

    private void setContent(String content) {
        validateContent(content);
        this.comments = comments;
    }

    private void validateContent(String content) {
        ValidationHelpers.validateStringLength(content,CONTENT_LEN_MIN,CONTENT_LEN_MAX,CONTENT_LEN_ERR);
    }

    @Override
    public String getComments() {
        return this.comments.toString();
    }

    @Override
    public String getAuthor() {
        return this.author;
    }


    @Override
    public String toString() {
        return getComments();
    }
}
