package org.example;

public class Car {
    int battery;
    double fuelAmount;
    int fuelCapacity;
    double fuelConsumption;
    int distanceTravelled;

    public Car(int battery, double fuelAmount, int fuelCapacity, double fuelConsumption, int distanceTravelled) {
        this.battery = battery;
        this.fuelAmount = fuelAmount;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.distanceTravelled = distanceTravelled;
    }

    public boolean turnOn(){
        return this.fuelAmount>10 && this.battery>5;
    }

    public boolean drive(int km){
        double zuzytePaliwo = km * this.fuelConsumption;
        if(zuzytePaliwo<=fuelAmount){
            fuelAmount = fuelAmount - zuzytePaliwo;
            distanceTravelled=distanceTravelled+km;
            return true;
        }
        return false;
    }

    public boolean refuel(double zatankowanePaliwo){
        if(zatankowanePaliwo<=0)
            return false;

        double nowaIloscPaliwa = zatankowanePaliwo + this.fuelAmount;
        this.fuelAmount = Math.min(nowaIloscPaliwa, fuelCapacity);
        return true;



    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
}
