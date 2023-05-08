package models.interfaces;

import models.CommentImpl;

import java.util.List;

public interface Comments {

    String getAuthor();

    String getContent();

    List<Comments> getComments();
}
