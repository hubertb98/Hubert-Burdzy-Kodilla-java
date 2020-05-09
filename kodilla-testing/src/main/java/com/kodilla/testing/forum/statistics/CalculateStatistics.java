package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    private int userQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public int getUserQuantity() {
        return userQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public double calculateAvgPostsPerUser(){
        if (userQuantity > 0) {
            return (double) postsQuantity / userQuantity;
        } else {
            return 0;
        }
    }

    public double calculateAvgCommentsPerUser() {
        if(userQuantity > 0) {
            return (double)commentsQuantity / userQuantity;
        } else {
            return 0;
        }
    }

    public double calculateAvgCommentsPerPost() {
        if(postsQuantity > 0) {
            return (double) commentsQuantity / postsQuantity;
        } else {
            return 0;
        }
    }

    public void calculateAdvStatistics(Statistics statistics) {
        userQuantity = statistics.userNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        avgPostsPerUser = calculateAvgPostsPerUser();
        avgCommentsPerUser = calculateAvgCommentsPerUser();
        avgCommentsPerPost = calculateAvgCommentsPerPost();
    }

    public void showStatistics() {
        System.out.println("User quantity: " + userQuantity);
        System.out.println("Posts quantity: " + postsQuantity);
        System.out.println("Comments quantity: " + commentsQuantity);
        System.out.println("Average posts per user: " + String.format("%.2f", avgPostsPerUser));
        System.out.println("Average comments per user: " + String.format("%.2f", avgCommentsPerUser));
        System.out.println("Average comments per post: " + String.format("%.2f", avgCommentsPerPost));
        System.out.println();
    }
}
