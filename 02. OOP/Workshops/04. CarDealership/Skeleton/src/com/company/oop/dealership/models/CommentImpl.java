package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Commentable;

import java.util.List;

import static java.lang.String.format;

public class CommentImpl implements Commentable {

    public static final int CONTENT_LEN_MIN = 3;
    public static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public List<Comment> getComments() {
        return null;
    }

    //TODO
}
