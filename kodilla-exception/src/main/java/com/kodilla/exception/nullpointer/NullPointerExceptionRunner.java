package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        User user2 = new User("Marcin");
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user2, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send," +
                    "but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }
}
