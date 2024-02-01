package ca.college.lasalle.oop.assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */
public class DataProvider {
    public static List<Payable> initialPayees() {
        List<Payable> payeeList = new ArrayList<>();
        //Full time employees
        payeeList.add(new FullTimer("Bruno", "Landeiro", 30, 4230));
        payeeList.add(new FullTimer("Ayrton", "Amaral", 28, 5230));
        payeeList.add(new FullTimer("Andrea", "Diaz", 28, 6230));
        payeeList.add(new FullTimer("Emily", "Liam", 28, 7230));
        payeeList.add(new FullTimer("Sophia", "Ethan", 28, 8230));
        //Part time employees
        payeeList.add(new PartTimer("Olivia", "Jackson", 28, Echelon.ONE, 800));
        payeeList.add(new PartTimer("Mia", "Diaz", 28, Echelon.TWO, 700));
        payeeList.add(new PartTimer("Aiden", "Olivia", 28, Echelon.THREE, 600));
        payeeList.add(new PartTimer("Ava", "Lemos", 28, Echelon.FOUR, 900));
        payeeList.add(new PartTimer("Noah", "Amaral", 28, Echelon.FIVE, 200));
        return payeeList;
    }
}
