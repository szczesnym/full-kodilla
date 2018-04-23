package com.kodilla.testing.forum.statistics;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import com.kodilla.testing.forum.statistic.ForumStatistics;
//import com.kodilla.testing.forum.statistics.Statistics;

import java.util.ArrayList;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;
    private ArrayList<String> usersNames;

    @Before
    public void beforeEveryTest() {
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    @Test
    public void testCalculateAdvStatistic0ALLCount() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvPostsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(0, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(0, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(0, sutAdvCommentsPerPost, 0.001);
    }

    @Test
    public void testCalculateAdvStatistic0User0PostCountCommentCount() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(150);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(0, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(0, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(0, sutAdvCommentsPerPost, 0.001);
    }

    @Test
    public void testCalculateAdvStatistic0UserPostCountCommentCount() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(450);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(0, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(0, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(450.0 / 1000.0, sutAdvCommentsPerPost, 0.001);
    }

    @Test
    public void testCalculateAdvStatisticUserPostCountCommentCount() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(2000);
        when(statisticsMock.commentsCount()).thenReturn(9000);
        usersNames = new ArrayList<>();
        usersNames.add("JohnDoe");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvPostsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(2000, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(9000, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(9000.0 / 2000.0, sutAdvCommentsPerPost, 0.001);
    }

    @Test
    public void TestCalculateAdvStatisticPostCountGreaterThenCommentCount() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(90);
        when(statisticsMock.commentsCount()).thenReturn(27);
        usersNames = new ArrayList<>();
        usersNames.add("JohnDoe");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvPostsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(90.0, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(27.0, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(27.0 / 90.0, sutAdvCommentsPerPost, 0.001);
    }

    @Test
    public void testCalculateAdvStatisticPostCountSmallerThenCommentCount() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(48);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        usersNames = new ArrayList<>();
        usersNames.add("JohnDoe");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvPostsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(48, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(1000, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(1000.0 / 48.0, sutAdvCommentsPerPost, 0.001);
    }

    @Test
    public void testCalculateAdvStatisticHundredUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(48);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("JohnDoe no:" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double sutAdvPostPerUser = forumStatistics.getAdvPostsPerUser();
        double sutAdvCommentsPerUser = forumStatistics.getAdvCommentsPerUser();
        double sutAdvCommentsPerPost = forumStatistics.getAdvCommentsPerPost();
        //Then
        Assert.assertEquals(48.0 / 100.0, sutAdvPostPerUser, 0.001);
        Assert.assertEquals(1000.0 / 100.0, sutAdvCommentsPerUser, 0.001);
        Assert.assertEquals(1000.0 / 48.0, sutAdvCommentsPerPost, 0.001);
    }
}
