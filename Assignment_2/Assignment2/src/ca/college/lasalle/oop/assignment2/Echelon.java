package ca.college.lasalle.oop.assignment2;

import java.util.Arrays;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public enum Echelon {

    ONE(1, 15),
    TWO(2, 20),
    THREE(3, 25),
    FOUR(4, 30),
    FIVE(5, 40);
    private int id;
    private double hourlyHate;

    Echelon(int id, double hourlyHate){
        this.id = id;
        this.hourlyHate = hourlyHate;
    }

    public int getId() {
        return id;
    }

    public double getHourlyHate() {
        return hourlyHate;
    }

    public static Echelon findById(int id) throws IllegalArgumentException {
        switch (id){
            case 1:
                return Echelon.ONE;
            case 2:
                return Echelon.TWO;
            case 3:
                return Echelon.THREE;
            case 4:
                return Echelon.FOUR;
            case 5:
                return Echelon.FIVE;
        }
        throw new IllegalArgumentException("The echelon id bust me between 1 and 5.");
    }

    public static void displayOptions(){
        for (Echelon e : Echelon.values()){
            System.out.println(String.format("%s - $%s hourly.", e.getId(), e.getHourlyHate()));
        }
    }
}
