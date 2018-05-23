package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {
    public ZGeneration() {
        this.socialPublisher = new SnapchatPublisher();
    }
}
