package com.kodilla.patterns.factory.tasks;

public abstract class CommonTask implements Task{
    protected String taskName;
    private boolean taskStatus = false;

    public CommonTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean isTaskExecuted() {
        return this.taskStatus;
    }
}
