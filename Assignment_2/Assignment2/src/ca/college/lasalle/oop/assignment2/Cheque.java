package ca.college.lasalle.oop.assignment2;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class Cheque {

    private static int counter = 1;
    private int chequeNo;
    private String payableTo;
    private double amount;

    public Cheque(String payableTo, double amount){
        this.payableTo = payableTo;
        this.amount = amount;
        this.chequeNo = Cheque.getNextChequeNo();
    }

    private static int getNextChequeNo(){
        return counter++;
    }

    public void display(){
        System.out.println("\nCheque number: " + this.chequeNo);
        System.out.println("Payable to: " + this.payableTo);
        System.out.println("Amount: $" + this.amount);
    }
}
