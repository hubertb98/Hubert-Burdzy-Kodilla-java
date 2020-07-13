package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialPublisher.FacebookPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User john = new Millenials("John Smith");
        User sophia = new YGeneration("Sophia Johnson");
        User ava = new ZGeneration("Ava Brown");

        //When
        String johnSharePost = john.sharePost();
        System.out.println("John post: " + johnSharePost);

        String sophiaSharePost = sophia.sharePost();
        System.out.println("Sophia post: " + sophiaSharePost);

        String avaSharePost = ava.sharePost();
        System.out.println("Ava post: " + avaSharePost);

        //Then
        Assert.assertEquals("Facebook", sophiaSharePost);
        Assert.assertEquals("Twitter", johnSharePost);
        Assert.assertEquals("Snapchat", avaSharePost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User john = new Millenials("John Smith");

        //When
        String johnSharePost = john.sharePost();
        System.out.println("John post: " + johnSharePost);
        john.setSocialMedia(new FacebookPublisher());
        johnSharePost = john.sharePost();
        System.out.println("John post now: " + johnSharePost);
        //Then
        Assert.assertEquals("Facebook", johnSharePost);
    }
}
