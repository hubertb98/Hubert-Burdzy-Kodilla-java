package com.kodilla.exception.nullpointer;

public class MessageSender {
    public void sendMessageTo(User user, String message) {
        if (user != null) {
            System.out.println("Sending message: " + message + " to " + user.getName());
        } else{
            try {
                throw new MessageNotSentException("Object User was null");
            } catch (MessageNotSentException e) {
                System.out.println("Message is not send, " +
                        "but my program still running very well!");
            }

            System.out.println("Processing other logic!");
        }
    }
}
