package com.kodilla.patterns.strategy.social;

public class User {
    protected SocialPublisher socialPublisher;

    public String sharePost() {
        return this.socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
