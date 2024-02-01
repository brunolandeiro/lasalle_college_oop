package ca.college.lasalle.oop.assignment2;

import java.util.Scanner;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class FullTimer extends Employee{
    private double salary;

    public FullTimer(String firstName, String lastName, int age, double salary) {
        super(firstName, lastName, age);
        this.salary = salary;
    }

    @Override
    public double getMonthlySalary() {
        return this.salary;
    }

}
