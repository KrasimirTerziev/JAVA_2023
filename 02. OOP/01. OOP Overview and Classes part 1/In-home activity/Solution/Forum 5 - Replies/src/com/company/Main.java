package com.company;

public class Main {

    public static void main(String[] args) {
        ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.");
        post1.replies.add("I like Google!");
        post1.replies.add("Ugh, Microsoft... :(");

        ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

        System.out.print(post1.format());
        // OUTPUT: How to find use for every Microsoft product. / by Steven, 0 votes.
        //         - I like Google!
        //         - Ugh, Microsoft... :(

        System.out.print(post2.format());
        // OUTPUT: Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
    }

}
