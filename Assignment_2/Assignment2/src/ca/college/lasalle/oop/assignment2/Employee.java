package ca.college.lasalle.oop.assignment2;

import java.util.Scanner;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public abstract class Employee implements Payable {

    private static int counter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    protected Employee(String firstName, String lastName, int age) {
        this.id = Employee.getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private static int getNextId(){
        return counter++;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public abstract double getMonthlySalary();

    @Override
    public Cheque issuePayCheque(){
        return new Cheque(getFullName(), getMonthlySalary());
    }

}
