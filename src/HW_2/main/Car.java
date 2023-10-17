package HW_2.main;

public class Car extends Vehicle {
    private String company;
    private String model;
    private int modelYear;
    private int numWheels;
    private int speed;

    public Car (String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.modelYear = year;
        this.numWheels = 4;
        this.speed = 0;
    }
    public void testDrive() {
        this.speed = 60;
    }
    public void park() {
        this.speed = 0;
    }
    public String getCompany() {
        return company;
    }
    public String getModel() {
        return model;
    }
    public int getModelYear() {
        return modelYear;
    }
    public int getNumWheels() {
        return numWheels;
    }
    public int getSpeed() {
        return speed;
    }
    public String toString() {
        return "This car is a “ + year + “ “ + make + “ “ + model + “;";
    }

}
