package com.company;

public class Main {

    public static void main(String[] args) {
        ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.", 2);

        ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

        System.out.printf("%s / by %s, %d votes. %n", post1.text, post1.author, post1.upVotes);
        // OUTPUT: How to find use for every Microsoft product. / by Steven, 2 votes.

        System.out.printf("%s / by %s, %d votes. %n", post2.text, post2.author, post2.upVotes);
        // OUTPUT: Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
    }

}
