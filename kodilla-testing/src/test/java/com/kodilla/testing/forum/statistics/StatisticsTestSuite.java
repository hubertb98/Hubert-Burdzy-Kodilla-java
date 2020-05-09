package com.kodilla.testing.forum.statistics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class StatisticsTestSuite {
    Statistics statisticsMock;
    CalculateStatistics calculateStatistics;

    @Before
    public void before() {
        statisticsMock = mock(Statistics.class);
        calculateStatistics = new CalculateStatistics();

        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(34);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 13; i ++) {
            users.add("User" + 1);
        }
        when(statisticsMock.userNames()).thenReturn(users);
    }
    @After
    public void after() {
        calculateStatistics.showStatistics();
    }

    @Test
    public void testClaculateStatisticsWhenPostsCountZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int postQuantity = calculateStatistics.getPostsQuantity();

        //Then
        Assert.assertEquals(0, postQuantity);
    }

    @Test
    public void testCalculateStatisticsWhenPostsCountThousand() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int postQuantity = calculateStatistics.getPostsQuantity();

        //Then
        Assert.assertEquals(1000, postQuantity);
    }

    @Test
    public void testCalculateStatisticsWhenCommentsCountZero() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int commentQuantity = calculateStatistics.getCommentsQuantity();

        //Then
        Assert.assertEquals(0, commentQuantity);
    }

    @Test
    public void testCalculateStatisticsWhenCommentsLessThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(30);

        //When
        double avgCommentsPerPost= calculateStatistics.calculateAvgCommentsPerPost();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0.3, avgCommentsPerPost, 1);
    }

    @Test
    public void testCalculateStatisticsWhenCommentsMoreThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.postsCount()).thenReturn(11);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double avgCommentsPerPost= calculateStatistics.calculateAvgCommentsPerPost();

        //Then
        Assert.assertEquals(4.5, avgCommentsPerPost, 1);
    }

    @Test
    public void testCalculateStatisticsWhenUsersCountZero(){
        //Given
        List<String> users = new ArrayList<>();
        when(statisticsMock.userNames()).thenReturn(users);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int normalList = statisticsMock.userNames().size();
        int userList = users.size();

        //Then
        Assert.assertEquals(normalList, userList);
    }

    @Test
    public void testCalculateStatisticsWhenUsersCountHundred(){
        //Given
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            users.add("User" + 1);
        }
        when(statisticsMock.userNames()).thenReturn(users);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int normalList = statisticsMock.userNames().size();
        int userList = users.size();

        //Then
        Assert.assertEquals(normalList, userList);

    }
}
