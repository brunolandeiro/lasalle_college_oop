import java.math.BigDecimal;

public class ConstructionEquipment extends RentalProduct {
    private String model;

    public ConstructionEquipment(String name, BigDecimal rentPrice, String model) {
        super(name, ProductType.CONSTRUCTION_EQUIPMENT, rentPrice);
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format(
                "ConstructionEquipment { Id: %s, Name: %s, Model: %s, Price: %s, Rent Date: %s, Return Date: %s }"
                , getId(), getName(), model, getRentPrice(), getRentDate(), getReturnDate());
    }
}
