package ca.college.lasalle.oop.assignment2;

import java.time.LocalDate;
import java.util.*;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class Main {

    public static void main(String[] args) {
        System.out.println("### Assignment 2 ###");

        //Provide the initial payees
        List<Payable> payeeList = DataProvider.initialPayees();
        Menu menu = new Menu();
        do {
            //Display the menu options
            menu.displayMenu();
            //Read de selected option from the console
            menu.selectOption();
            switch (menu.getSelectedOption()) {
                case 1:
                    //Create a new employee using the provided data
                    Employee employee = ConsoleReader.newEmployee();
                    if(employee != null){
                        payeeList.add(employee);
                    }
                    break;
                case 2:
                    //Create a new Bill using the provided data
                    Bill bill = ConsoleReader.newBill();
                    if(bill != null){
                        payeeList.add(bill);
                    }
                    break;
                case 3:
                    //Issue cheque for each payee available in the payeeList
                    System.out.println("Issued cheques:");
                    for (Payable payee : payeeList) {
                        Cheque cheque = payee.issuePayCheque();
                        cheque.display();
                    }
                    break;
            }
        } while (menu.getSelectedOption() != 4);

    }

}