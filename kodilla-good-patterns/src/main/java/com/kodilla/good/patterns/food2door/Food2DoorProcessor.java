package com.kodilla.good.patterns.food2door;

public interface Food2DoorProcessor {
    public boolean process();
    public Food2DoorItem itemNoMapper(Food2DoorItem itemByF2D);
    public String connectToSupplier();

}
