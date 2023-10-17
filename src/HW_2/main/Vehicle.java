package HW_2.main;

public abstract class Vehicle {
    private String company;
    private String model;
    private int modelYear;
    private int numWheels;
    private int speed;
    public abstract void testDrive();
    public abstract void park();
}
