package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final List<HomeworkObserver> homeworkObservers;
    private String homeworkQueueName;
    private List<HomeworkTask> homeworkTaskList;

    public HomeworkQueue(String queueName) {
        this.homeworkQueueName = queueName;
        homeworkTaskList = new ArrayList<>();
        homeworkObservers = new ArrayList<>();
    }

    public void add(HomeworkTask homeworkTask) {
        homeworkTaskList.add(homeworkTask);
        notifyObservers(homeworkTask);
    }

    @Override
    public void registerObserver(HomeworkObserver observer) {
        homeworkObservers.add(observer);
    }

    @Override
    public void removeObserver(HomeworkObserver observer) {
        homeworkObservers.remove(observer);
    }

    @Override
    public void notifyObservers(HomeworkTask homeworkTask) {
        for (HomeworkObserver mentor : homeworkObservers) {
            mentor.update(homeworkTask);
        }
    }

    public String getHomeworkQueueName() {
        return homeworkQueueName;
    }

    public List<HomeworkTask> getHomeworkTaskList() {
        return homeworkTaskList;
    }
}
