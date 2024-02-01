package com.landeiro.bruno.model;
// Bruno Landeiro - 2234156
public class Motorcycle extends Vehicle{
    private String type;

    public Motorcycle(String make, int year, String type){
        super(make, year);
        if(!"Sportbike".equals(type) && !"Cruiser".equals(type)){
            throw new IllegalArgumentException("The motorcycle's type must be Sportbike or Cruiser");
        }
        this.type = type;
    }
    @Override
    public void start() {
        if("malfunction".equals(this.getStatus())){
            throw new RuntimeException("The motorcycle cannot be started, it is malfunction.");
        }
        this.setStatus("started");
    }

    @Override
    public void stop() {
        if("malfunction".equals(this.getStatus())){
            throw new RuntimeException("The motorcycle cannot be started, it is malfunction.");
        }
        this.setStatus("stopped");
    }

    public void setAsMalfunction() {
        this.setStatus("malfunction");
    }

    @Override
    public String toString() {
        return "Motorcycle{ " +
                "make=" + this.getMake() +
                ", year=" + this.getYear() +
                ", status=" + this.getStatus() +
                ", type=" + this.type +
                '}';
    }
}
