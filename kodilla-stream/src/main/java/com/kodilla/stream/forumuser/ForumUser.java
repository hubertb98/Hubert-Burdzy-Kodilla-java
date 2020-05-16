package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int publishedPostQuantity;

    public ForumUser(final int userId, final String username, final char sex,
                     final int yearOfBirth, final int monthOfBirth, final int dayOfBirth,
                     final int publishedPostQuantity) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.publishedPostQuantity = publishedPostQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPublishedPostQuantity() {
        return publishedPostQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", publishedPostQuantity=" + publishedPostQuantity +
                '}';
    }
}
