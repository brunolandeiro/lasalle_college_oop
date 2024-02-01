import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalProduct implements Rentable{

    private static int counter = 1;
    private int id;
    private String name;
    private ProductType type;
    private BigDecimal rentPrice;
    private LocalDate rentDate;
    private LocalDate returnDate;

    public RentalProduct(String name, ProductType type, BigDecimal rentPrice) {
        this.id = counter++;
        this.name = name;
        this.type = type;
        this.rentPrice = rentPrice;
    }

    @Override
    public long getDuration() {
        if(this.rentDate != null){
            return  ChronoUnit.DAYS.between(rentDate, returnDate);
        }
        return 0L;
    }

    @Override
    public BigDecimal getRentPrice() {
        return this.rentPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setRentDate(){
        this.rentDate = LocalDate.now();
    }

    public void setReturnDate(LocalDate returnDate) {
        if(returnDate.isBefore(LocalDate.now())){
            throw new RuntimeException("The return date must be after: " + LocalDate.now());
        }
        this.returnDate = returnDate;
    }

    public boolean isRented() {
        return !this.isAvailable();
    }
    public boolean isAvailable() {
        return this.rentDate == null;
    }

}
