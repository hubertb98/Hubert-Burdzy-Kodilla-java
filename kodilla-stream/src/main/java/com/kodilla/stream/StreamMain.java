package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> theResultMapOfUser = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> 2020 - user.getBirthDate().getYear() > 20)
                .filter(user -> user.getPublishedPostQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        theResultMapOfUser.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
