package com.kodilla.patterns.factory.tasks;

public class PaintingTask extends CommonTask{
    String color;
    String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        super(taskName);
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing Paining Task");
        setTaskStatus(true);
    }

    public String getColor() {
        return color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }
}
