import java.util.Scanner;

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
        System.out.println("1. Add a construction equipment to the company’s inventory");
        System.out.println("2. Add a motorcycle to the company’s inventory");
        System.out.println("3. Add a book to the company’s inventory");
        System.out.println("4. Rent an equipment");
        System.out.println("5. Display rented equipment with their info (info of each rented equipment, date of return, rent value)");
        System.out.println("6. Display equipment in inventory that is not rented");
        System.out.println("7. Exit");
        System.out.println("Please, enter with one of the options above.");
    }
    public int getSelectedOption(){
        return selectedOption;
    }
}
