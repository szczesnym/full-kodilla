package com.kodilla.patterns.strategy.social;

public class Millenials extends User {
    public Millenials() {
        this.socialPublisher = new FacebookPublisher();
    }
}
