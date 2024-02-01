package ca.college.lasalle.oop.assignment2;

import java.util.Scanner;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class Menu {
    private int selectedOption = 0;

    public void selectOption(){
        Scanner scanner = new Scanner(System.in);
        try {
            this.selectedOption = scanner.nextInt();
        } catch (Exception e){
            scanner.next();
        }
    }

    public void displayMenu() {
        System.out.println("\nMenu: ");
        System.out.println("1. Add an employee");
        System.out.println("2. Add a bill");
        System.out.println("3. Issue cheques");
        System.out.println("4. Exit");
        System.out.println("Please, enter with one of the options above.");
    }

    public int getSelectedOption(){
        return selectedOption;
    }
}
