package ca.college.lasalle.oop.assignment2;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);
    public static Employee newEmployee(){
        int selectedOption = 0;
        do{
            System.out.println("\nNew employee: ");
            System.out.println("\t1. Part time");
            System.out.println("\t2. Full time");
            System.out.println("\t3. Exit");
            System.out.println("Please, enter with one of the options above.");
            try{
                selectedOption = scanner.nextInt();
            } catch (Exception e){
                scanner.next();
                selectedOption = 0;
            }
        } while(selectedOption < 1 || selectedOption > 3);
        if(selectedOption == 1 || selectedOption == 2){
            String firstName = readStringFromConsole("Employee first name:");
            String lastName = readStringFromConsole("Employee last name:");
            int age = readIntegerFromConsole("Employee age:", 18, 120);
            if(selectedOption == 1){
                Echelon echelon = readEchelon();
                int nbHoursWorked =readIntegerFromConsole("Employee number of hours worked:", 0, 744);
                return new PartTimer(firstName, lastName, age, echelon, nbHoursWorked);
            }
            else {
                double salary = readDoubleFromConsole("Employee salary:", 0, 999999);
                return new FullTimer(firstName, lastName, age, salary);
            }
        }
        return null;
    }

    private static Echelon readEchelon() {
        Echelon.displayOptions();
        int echelonId = readIntegerFromConsole("Employee echelon:", 1, 5);
        Echelon echelon = Echelon.findById(echelonId);
        return echelon;
    }

    public static Bill newBill(){
        double amountToPay = readDoubleFromConsole("Bill amount to pay:", 1, 999999);
        int year = readIntegerFromConsole("Bill due date year:", LocalDate.now().getYear(), LocalDate.now().getYear()+3);
        int month = readIntegerFromConsole("Bill due date month:", 1, 12);
        int day = readIntegerFromConsole("Bill due date day:", 1, 31);
        LocalDate dueDate = LocalDate.of(year, month, day);
        String companyName = readStringFromConsole("Bill company name");
        return new Bill(amountToPay,LocalDate.now(),companyName);
    }

    private static String readStringFromConsole(String msgToUser){
        String text;
        do {
            System.out.println(msgToUser);
            text = scanner.next();
        } while (text == null || text.isBlank());
        return text;
    }

    private static int readIntegerFromConsole(String msgToUser, int minValidValue, int maxValidValue){
        int value = minValidValue-1;
        do {
            System.out.println(String.format("%s (min %s, max %s)",msgToUser, minValidValue, maxValidValue));
            try{
                value = scanner.nextInt();
            } catch (Exception e){
                scanner.next();
            }
        } while (value < minValidValue || value > maxValidValue);
        return value;
    }

    private static double readDoubleFromConsole(String msgToUser, double minValidValue, double maxValidValue){
        double value = minValidValue-1;
        do {
            System.out.println(String.format("%s (min %s, max %s)",msgToUser, minValidValue, maxValidValue));
            try{
                value = scanner.nextInt();
            } catch (Exception e){
                scanner.next();
            }
        } while (value < minValidValue || value > maxValidValue);
        return value;
    }
}
