package ca.college.lasalle.oop.assignment2;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class PartTimer extends Employee {
    private Echelon echelon;
    private int nbHoursWorked;

    public PartTimer(String firstName, String lastName, int age, Echelon echelon, int nbHoursWorked) {
        super(firstName, lastName, age);
        this.echelon = echelon;
        this.nbHoursWorked = nbHoursWorked;
    }

    @Override
    public double getMonthlySalary() {
        return nbHoursWorked * echelon.getHourlyHate();
    }

}
