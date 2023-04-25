package com.company.oop.dealership.models.contracts;

import java.util.List;

public interface Commentable extends Comment{

    List<Comment> getComments();
}
