package com.company;

public class Main {

    public static void main(String[] args) {
        ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.");

        ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

        System.out.print(post1.format());
        // OUTPUT: How to find use for every Microsoft product. / by Steven, 0 votes.

        System.out.print(post2.format());
        // OUTPUT: Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
    }

}
