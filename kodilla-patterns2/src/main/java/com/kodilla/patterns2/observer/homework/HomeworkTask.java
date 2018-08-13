package com.kodilla.patterns2.observer.homework;

import java.util.List;

public class HomeworkTask {
    private String module;
    private String studentName;
    private boolean isAccepted;

    public HomeworkTask(String module, String studentName) {
        this.module = module;
        this.studentName = studentName;
        isAccepted = false;
    }

    public String getModule() {
        return module;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public String toString() {
        return "HomeworkTask{" +
                "module='" + module + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
