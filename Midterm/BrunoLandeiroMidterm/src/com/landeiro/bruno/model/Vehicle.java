package com.landeiro.bruno.model;
// Bruno Landeiro - 2234156
public abstract class Vehicle {

    private String make;
    private int year;
    private String status;

    public Vehicle(String make, int year){
        this.make = make;
        this.year = year;
        this.status = "stopped";
    }

    protected String getMake() {
        return make;
    }

    protected int getYear() {
        return year;
    }

    protected String getStatus() {
        return status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    public void display(){
        System.out.println(this.toString());
    }

    public abstract void start();

    public abstract void stop();
}
