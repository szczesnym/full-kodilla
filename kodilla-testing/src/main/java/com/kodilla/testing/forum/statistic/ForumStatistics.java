package com.kodilla.testing.forum.statistic;

public class ForumStatistics {
    private double advPostsPerUser, advCommentsPerUser, advCommentsPerPost;
    private int usersCount, postsCount, commentsCount;

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAdvPostsPerUser() {
        return advPostsPerUser;
    }

    public double getAdvCommentsPerUser() {
        return advCommentsPerUser;
    }

    public double getAdvCommentsPerPost() {
        return advCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();
        if (postsCount != 0) {
            this.advCommentsPerPost = (double) this.commentsCount / this.postsCount;
        }
        if (usersCount != 0) {
            this.advCommentsPerUser = (double) this.commentsCount / this.usersCount;
            this.advPostsPerUser = (double) this.postsCount / this.usersCount;
        }
    }

    public void showStatistics() {
        System.out.format("Adv posts per user:%f, Adv Comments per user:%f, Adv no. of comments per posts:%f", this.advPostsPerUser, this.advCommentsPerUser, this.advCommentsPerPost);
    }
}
