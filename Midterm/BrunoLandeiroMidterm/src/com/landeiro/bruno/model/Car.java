package com.landeiro.bruno.model;
// Bruno Landeiro - 2234156
public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String make, int year, int numberOfDoors) {
        super(make, year);
        if(numberOfDoors < 2 || numberOfDoors > 5){
            throw new IllegalArgumentException("The car's numbers of doors must be 2, 3, 4, or 5");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        this.setStatus("started");
    }

    @Override
    public void stop() {
        this.setStatus("stopped");
    }

    @Override
    public String toString() {
        return "Car{" +
                "make=" + this.getMake() +
                ", year=" + this.getYear() +
                ", status=" + this.getStatus() +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}
