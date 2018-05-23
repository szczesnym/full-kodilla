package com.kodilla.patterns.strategy.social;

public class YGeneration extends User {
    public YGeneration() {
        this.socialPublisher = new TwitterPublisher();
    }
}
