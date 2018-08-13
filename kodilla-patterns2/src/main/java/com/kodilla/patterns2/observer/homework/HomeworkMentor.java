package com.kodilla.patterns2.observer.homework;


public class HomeworkMentor implements HomeworkObserver {
    private String mentorName;
    private int updateCount;

    public HomeworkMentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(HomeworkTask homeworkTask) {
        System.out.format("New homework task:%s for mentor:%s\n", homeworkTask, this.mentorName);
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
