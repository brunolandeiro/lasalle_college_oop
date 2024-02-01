import java.math.BigDecimal;

public class Book extends RentalProduct{
    private String author;
    public Book(String name, BigDecimal rentPrice, String author) {
        super(name, ProductType.BOOK, rentPrice);
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format(
                "Book { Id: %s, Name: %s, Author: %s, Price: %s, Rent Date: %s, Return Date: %s }"
                , getId(), getName(), author, getRentPrice(), getRentDate(), getReturnDate());
    }
}
