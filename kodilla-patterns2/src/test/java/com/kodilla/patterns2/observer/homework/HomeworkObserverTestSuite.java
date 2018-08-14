package com.kodilla.patterns2.observer.homework;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomeworkObserverTestSuite {

    @Test
    public void testShouldNotyfiMalgorzaTwiceJerzyOnce() {
        //Given
        HomeworkTask task1 = new HomeworkTask("20", "MarcinS");
        HomeworkTask task2 = new HomeworkTask("21", "MarcinS");
        HomeworkTask task3 = new HomeworkTask("22", "MarcinS");

        HomeworkQueue javaQueue = new HomeworkQueue("JavaBootCamp");
        HomeworkQueue frontEndQueue = new HomeworkQueue("FrontEndBootCamp");

        HomeworkMentor malgorzataMentor = new HomeworkMentor("Małgorzata");
        HomeworkMentor jerzyMentor = new HomeworkMentor("Jerzy");

        javaQueue.registerObserver(malgorzataMentor);
        frontEndQueue.registerObserver(malgorzataMentor);
        frontEndQueue.registerObserver(jerzyMentor);
        //When

        javaQueue.add(task1);
        frontEndQueue.add(task2);
        frontEndQueue.add(task3);

        //Then
        assertEquals(3, malgorzataMentor.getUpdateCount());
        assertEquals(2, jerzyMentor.getUpdateCount());
    }
}
