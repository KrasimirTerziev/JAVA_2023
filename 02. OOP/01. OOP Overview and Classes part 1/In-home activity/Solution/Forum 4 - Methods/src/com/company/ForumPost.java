package com.company;

public class ForumPost {

    String author;
    String text;
    int upVotes;

    public ForumPost(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public ForumPost(String author, String text, int upVotes) {
        this.author = author;
        this.text = text;
        this.upVotes = upVotes;
    }

    public String format() {
        return String.format("%s / by %s, %d votes. %n", this.text, this.author, this.upVotes);
    }

}
