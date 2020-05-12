package com.kodilla.testing.forum.statistics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void testCalculateStatisticsWhenPostsCountZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int userQuantity = calculateStatistics.getUserQuantity();
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();


        //Then
        assertEquals(13, userQuantity);
        assertEquals(0, postQuantity);
        assertEquals(34, commentsQuantity);
        assertEquals(0.0, avgPostPerUser, 0.1);
        assertEquals(2.6, avgCommentPerUser, 0.1);
        assertEquals(0.0, avgCommentsPerPost, 0.1);

    }

    @Test
    public void testCalculateStatisticsWhenPostsCountThousand() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int userQuantity = calculateStatistics.getUserQuantity();
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();

        //Then
        assertEquals(13, userQuantity);
        assertEquals(1000, postQuantity);
        assertEquals(34, commentsQuantity);
        assertEquals(76.9, avgPostPerUser, 0.1);
        assertEquals(2.6, avgCommentPerUser, 0.1);
        assertEquals(0.0, avgCommentsPerPost, 0.1);
    }

    @Test
    public void testCalculateStatisticsWhenCommentsCountZero() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int userQuantity = calculateStatistics.getUserQuantity();
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();

        //Then
        assertEquals(13, userQuantity);
        assertEquals(10, postQuantity);
        assertEquals(0, commentsQuantity);
        assertEquals(0.7, avgPostPerUser, 0.1);
        assertEquals(0.0, avgCommentPerUser, 0.1);
        assertEquals(0.0, avgCommentsPerPost, 0.1);
    }

    @Test
    public void testCalculateStatisticsWhenCommentsLessThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(30);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int userQuantity = calculateStatistics.getUserQuantity();
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();

        //Then
        assertEquals(13, userQuantity);
        assertEquals(30, postQuantity);
        assertEquals(10, commentsQuantity);
        assertEquals(2.3, avgPostPerUser, 0.1);
        assertEquals(0.7, avgCommentPerUser, 0.1);
        assertEquals(0.3, avgCommentsPerPost, 0.1);
    }

    @Test
    public void testCalculateStatisticsWhenCommentsMoreThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.postsCount()).thenReturn(11);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        int userQuantity = calculateStatistics.getUserQuantity();
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();

        //Then
        assertEquals(13, userQuantity);
        assertEquals(11, postQuantity);
        assertEquals(50, commentsQuantity);
        assertEquals(0.8, avgPostPerUser, 0.1);
        assertEquals(3.8, avgCommentPerUser, 0.1);
        assertEquals(4.5, avgCommentsPerPost, 0.1);
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
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();

        //Then
        assertEquals(normalList, userList);
        assertEquals(10, postQuantity);
        assertEquals(34, commentsQuantity);
        assertEquals(0, avgPostPerUser, 0);
        assertEquals(0, avgCommentPerUser, 0);
        assertEquals(3.4, avgCommentsPerPost, 0.1);
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
        int userQuantity = calculateStatistics.getUserQuantity();
        int postQuantity = calculateStatistics.getPostsQuantity();
        int commentsQuantity = calculateStatistics.getCommentsQuantity();
        double avgPostPerUser = calculateStatistics.getAvgPostsPerUser();
        double avgCommentsPerPost = calculateStatistics.getAvgCommentsPerPost();
        double avgCommentPerUser = calculateStatistics.calculateAvgCommentsPerUser();

        //Then
        assertEquals(normalList, userList);
        assertEquals(100, userQuantity);
        assertEquals(10, postQuantity);
        assertEquals(34, commentsQuantity);
        assertEquals(0.1, avgPostPerUser, 0.1);
        assertEquals(0.34, avgCommentPerUser, 0.1);
        assertEquals(3.4, avgCommentsPerPost, 0.1);

    }
}
