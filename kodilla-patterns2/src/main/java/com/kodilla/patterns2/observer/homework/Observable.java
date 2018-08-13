package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(HomeworkObserver observer);

    void notifyObservers(HomeworkTask homeworkTask);

    void removeObserver(HomeworkObserver observer);
}
