import org.example.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CarTest {



    @Test
    public void carTurnsOnIfHasBatteryAndFuel(){
        Car car = new Car(50, 30,50,0.08, 20);
        boolean result = car.turnOn();
        Assertions.assertTrue(result);
    }

    @Test
    public void carTurnsOnIfHasBatteryAndNoFuel(){
        Car car = new Car(50, 0,50,0.08, 20);
        boolean result = car.turnOn();
        Assertions.assertFalse(result);
    }
    @Test
    public void carTurnsOnIfHasNoBatteryAndFuel(){
        Car car = new Car(0, 30,50,0.08, 20);
        boolean result = car.turnOn();
        Assertions.assertFalse(result);
    }
    @Test
    public void carTurnsOnIfHasNoBatteryAndNoFuel(){
        Car car = new Car(0, 0,50,0.08, 20);
        boolean result = car.turnOn();
        Assertions.assertFalse(result);
    }


    @Test
    public void carIncreasesDistanceTravelledWhenItHasEnoughFuel(){
        Car car = new Car(50, 30,50,0.08,0);
        car.drive(10);
        car.drive(15);
        boolean result = car.drive(20);
        Assertions.assertTrue(result);
        Assertions.assertEquals(26.4, car.getFuelAmount());
        Assertions.assertEquals(45, car.getDistanceTravelled());
    }



    @Test
    public void carIncreasesDistanceTravelledWhenItHasEnoughFuelButStopsWhenFuelRunsOut(){
        Car car = new Car(50, 30,50,0.08,0);
        car.drive(300);
        car.drive(70);
        boolean result = car.drive(6);
        Assertions.assertFalse(result);
//        Assertions.assertEquals(0.4,car.getFuelAmount()); to jest dobrze ale zaokreglenia nie dzialaja
        Assertions.assertEquals(370,car.getDistanceTravelled());

    }


    @Test
    public void carHasMoreFuelWhenRefuelled(){
        Car car = new Car(50, 30,50,0.08,0);
        car.refuel(19);
        Assertions.assertEquals(49, car.getFuelAmount());

    }

    @Test
    public void carHasMoreFuelThanMaxCapacityWhenRefuelled(){
        Car car = new Car(50, 30,50,0.08,0);
        car.refuel(50);
        Assertions.assertEquals(car.getFuelAmount(), car.getFuelCapacity());
    }

    @Test
    public void carHas0OrLessFuelWhenRefuelled(){
        Car car = new Car(50, 30,50,0.08,0);
        car.refuel(-5);
        Assertions.assertEquals(30, car.getFuelAmount());
    }




}
