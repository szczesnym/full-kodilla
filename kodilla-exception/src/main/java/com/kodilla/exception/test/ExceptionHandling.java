package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge;
        String secondChallengeResult = "";

        System.out.println("First attempt ->");
        try {
            secondChallenge = new SecondChallenge();
            secondChallengeResult = secondChallenge.probablyIWillThrowException(1.5, 0);
        } catch (Exception e) {
            System.out.println("Excpetion -> x >= 2 or x < 1 or y == 1.5");
        } finally {
            System.out.println("End of Second Challenge with result:" + secondChallengeResult);
        }
        System.out.println("<- End of first attempt\nSecond attempt ->");
        try {
            secondChallenge = new SecondChallenge();
            secondChallengeResult = secondChallenge.probablyIWillThrowException(2, 0);
        } catch (Exception e) {
            System.out.println("Excpetion -> x >= 2 or x < 1 or y == 1.5");
        } finally {
            System.out.println("End of Second Challenge with result:" + secondChallengeResult);
        }
        System.out.println("<- End of second attempt");
    }
}
