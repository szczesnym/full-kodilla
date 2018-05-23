package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTestSuite {
    User milenial, yGeneration, zGeneration;

    @Before
    public void initializeTest() {
        milenial = new Millenials();
        yGeneration = new YGeneration();
        zGeneration = new ZGeneration();
    }

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        //When
        //Then
        Assert.assertEquals("This is FaceBook post", milenial.sharePost());
        Assert.assertEquals("This is Twitter post", yGeneration.sharePost());
        Assert.assertEquals("This is Snapchat post", zGeneration.sharePost());

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        SocialPublisher faceBookPubliser = new FacebookPublisher();
        //When
        yGeneration.setSocialPublisher(faceBookPubliser);
        //Then
        Assert.assertEquals("This is FaceBook post", yGeneration.sharePost());
    }
}
