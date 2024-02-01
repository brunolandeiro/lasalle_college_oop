package ca.college.lasalle.oop.assignment2;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
* */
public class Bill implements Payable {
    private double amountToPaid;
    private LocalDate dueDate;
    private String companyName;

    public Bill(double amountToPaid, LocalDate dueDate, String companyName) {
        this.amountToPaid = amountToPaid;
        this.dueDate = dueDate;
        this.companyName = companyName;
    }

    @Override
    public Cheque issuePayCheque() {
        return new Cheque(companyName, amountToPaid);
    }

}
