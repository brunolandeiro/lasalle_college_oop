package com.landeiro.bruno;

import com.landeiro.bruno.model.Car;
import com.landeiro.bruno.model.Motorcycle;
import com.landeiro.bruno.model.Vehicle;
// Bruno Landeiro - 2234156
public class Main {
    public static void main(String[] args) {
        //Initial vehicles
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Car("Toyota",2023, 2);
        vehicles[1] = new Car("Toyota",2022, 3);
        vehicles[2] = new Car("Toyota",2021, 4);

        vehicles[3] = new Motorcycle("Honda",2023, "Sportbike");
        vehicles[4] = new Motorcycle("Honda",2022, "Cruiser");
        vehicles[5] = new Motorcycle("Honda",2021, "Cruiser");

        //starting the first car
        vehicles[0].start();
        //stopping the second car
        vehicles[1].stop();
        //setting the status of the first motorcyle as malfunction
        ((Motorcycle) vehicles[3]).setAsMalfunction();

        //trying to set the status of the first motorcycle as start
        try{
            vehicles[3].start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //displaying each string representation of the vehicles
        for(Vehicle vehicle : vehicles){
            vehicle.display();
        }

    }
}