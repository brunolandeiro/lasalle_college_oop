import java.math.BigDecimal;

public class Motocycle extends RentalProduct {
    private String model;

    public Motocycle(String name, BigDecimal rentPrice, String model) {
        super(name, ProductType.MOTOCYCLE, rentPrice);
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format(
                "Motorcycle { Id: %s, Name: %s, Model: %s, Price: %s, Rent Date: %s, Return Date: %s }"
                , getId(), getName(), model, getRentPrice(), getRentDate(), getReturnDate());
    }
}
