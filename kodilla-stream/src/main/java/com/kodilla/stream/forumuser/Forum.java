package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "jacobSmith", 'M', 1997, 3, 10, 6));
        userList.add(new ForumUser(2, "isabellaBrown", 'F', 2003, 4, 5, 0));
        userList.add(new ForumUser(3, "oliviaGarcia", 'F', 1996, 12, 30, 5));
        userList.add(new ForumUser(4, "ethanMoore", 'M', 1991, 5, 24, 3));
        userList.add(new ForumUser(5, "williamWilson", 'M', 2009, 10, 21, 0));
        userList.add(new ForumUser(6, "avaHernandez", 'F', 2006, 9, 10, 5));
        userList.add(new ForumUser(7, "michaelTaylor", 'M', 1986, 1, 3, 16));
    }

    public List<ForumUser> getUserList() {
        return userList;
    }
}
