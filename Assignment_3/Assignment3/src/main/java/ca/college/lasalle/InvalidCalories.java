package ca.college.lasalle;

public class InvalidCalories extends RuntimeException {
    InvalidCalories(String message){
        super(message);
    }
}