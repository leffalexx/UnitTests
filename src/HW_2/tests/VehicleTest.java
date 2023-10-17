package HW_2.tests;
import HW_2.main.Car;
import HW_2.main.Motorcycle;
import HW_2.main.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class VehicleTest {
    @Test
    public void testCarInstance()  {
        Car car = new Car("Skoda", "Octavia", 2014);
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    public void testCarHasFourWheels() {
        Car car = new Car("Skoda", "Fabia", 2010);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testBikeHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Ducati", "Monster", 2020);
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void testCarSpeed() {
        Car car = new Car("Pagani", "Zonda", 2007);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void testBikeSpeed() {
        Motorcycle motorcycle = new Motorcycle("Triumph", "Spitfire", 1957);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void testCarSpeedAtStop() {
        Car car = new Car("Tesla", "Model Y", 2023);
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testBikeSpeedAtStop() {
        Motorcycle motorcycle = new Motorcycle("Honda", "Fireblade", 2022);
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
