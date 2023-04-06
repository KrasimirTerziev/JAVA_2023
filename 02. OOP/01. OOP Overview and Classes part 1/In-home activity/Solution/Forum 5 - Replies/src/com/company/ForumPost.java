package com.company;

import java.util.ArrayList;

public class ForumPost {

    String author;
    String text;
    int upVotes;

    ArrayList<String> replies = new ArrayList<>();

    public ForumPost(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public ForumPost(String author, String text, int upVotes) {
        this(author, text);
        this.upVotes = upVotes;
    }

    public String format() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s / by %s, %d votes. %n", this.text, this.author, this.upVotes));

        for (String reply : replies) {
            builder.append(String.format("- %s%n", reply));
        }

        return builder.append(System.lineSeparator()).toString();
    }

}
