package com.kodilla.patterns.factory.tasks;

public class DrivingTask extends CommonTask{
    String where;
    String using;

    public DrivingTask(String taskName, String where, String using) {
        super(taskName);
        this.where = where;
        this.using = using;
    }
    @Override
    public void executeTask() {
        System.out.println("Executing Driving Task");
        setTaskStatus(true);
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}
