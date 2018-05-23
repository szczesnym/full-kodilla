package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public final CommonTask makeTask(TaskEnum taskEnum) {
        switch (taskEnum) {
            case Shopping: {
                return new ShoppingTask("Shopping task", "Car", 1.0);
            }
            case Painting: {
                return new PaintingTask("Painting Task", "Black", "Walls");
            }
            case Driving: {
                return new DrivingTask("Driving Task", "Home", "Motorbike");
            }
            default: return null;

        }
    }
}
