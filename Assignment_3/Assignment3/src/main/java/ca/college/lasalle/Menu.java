package ca.college.lasalle;
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
        System.out.println("1.\tAdd chocolate bar");
        System.out.println("2.\tAdd a sandwich");
        System.out.println("3.\tAdd gas");
        System.out.println("4.\tAdd coffee");
        System.out.println("5.\tDisplay all chocolate bars");
        System.out.println("6.\tCompare two chocolate bars and display which one is healthier");
        System.out.println("7.\tDisplay all sandwiches");
        System.out.println("8.\tCompare two sandwiches and display which one is cheaper");
        System.out.println("9.\tSell an edible item");
        System.out.println("10.\tSell gas");
        System.out.println("11.\tSell coffee");
        System.out.println("12.\tDisplay how much gas do we have in tanks");
        System.out.println("13.\tExit");
        
        System.out.println("Please, enter with one of the options above.");
    }

    public int getSelectedOption(){
        return selectedOption;
    }
}