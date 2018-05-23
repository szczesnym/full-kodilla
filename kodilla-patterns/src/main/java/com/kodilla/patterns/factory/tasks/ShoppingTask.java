package com.kodilla.patterns.factory.tasks;

public class ShoppingTask extends CommonTask{
    private String whatToBuy;
    private double quantity;

    public ShoppingTask(String taskname, String whatToBuy, double quantity) {
        super(taskname);
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }
    @Override
    public void executeTask() {
       System.out.println("Executing Shopping Task");
       setTaskStatus(true);
    }

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
    }
}
