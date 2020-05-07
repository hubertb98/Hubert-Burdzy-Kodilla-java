package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

        //When
        forumUser.addPost("mrsmith", "First Post");

        //Then
        Assert.assertEquals(1, forumUser.getPostQuantity());
    }

    @Test
    public void testAddComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone!" +
                "This is my first post!", "mrSmith");

        //When
        forumUser.addComment(thePost, "mrSmith", "Thank you for all good words!");

        //Then
        Assert.assertEquals(1, forumUser.getCommentQuantity());

    }

    @Test
    public void testGetPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Post", "mrSmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);

        //Then
        Assert.assertEquals(thePost, retrievedPost);

    }

    @Test
    public void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Post", "mrSmith");
        ForumComment theComment = new ForumComment(thePost, "mrSmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        //When
        ForumComment retrievedComment;
        retrievedComment = forumUser.getComment(0);

        //Then
        Assert.assertEquals(theComment, retrievedComment);

    }

    @Test
    public void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Post", "mrSmith");

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCommentNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Post", "mrSmith");
        ForumComment theComment = new ForumComment(thePost,"mrSmith",
                "Thank you for all good words!");

        //When
        boolean result = forumUser.removeCommet(theComment);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Post", "mrSmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostQuantity());
    }

    @Test
    public void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone!" +
                "This is my first post!", "mrSmith");
        ForumComment theComment = new ForumComment(thePost,"mrSmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        //When
        boolean result = forumUser.removeCommet(theComment);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentQuantity());

    }

}
