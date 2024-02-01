import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsController {

    private static List<RentalProduct> products = new ArrayList<>();

    public static void addRentalProduct(ProductType type) {
        System.out.println("\n*********** Add a product ***********");
        String name = ConsoleReader.readAsString("Product Name:");
        BigDecimal price = ConsoleReader.readAsBigDecimal("Rent Price (CAD $): ");

        if(ProductType.CONSTRUCTION_EQUIPMENT == type){
            String model = ConsoleReader.readAsString("Construction Equipment Model:");
            products.add(new ConstructionEquipment(name, price, model));
        }

        if(ProductType.BOOK == type){
            String author = ConsoleReader.readAsString("Book Author:");
            products.add(new Book(name, price, author));
        }

        if(ProductType.MOTOCYCLE == type){
            String model = ConsoleReader.readAsString("Motorcycle Model:");
            products.add(new Motocycle(name, price, model));
        }
    }

    public static void rentEquipment() {
        System.out.println("\n*********** Rent an equipment ***********");
        displayNotRentedEquipment();
        int id = ConsoleReader.readAsInteger("Select product by id:");
        LocalDate returnDate = ConsoleReader.readAsLocalDate("Return Date (yyyy-MM-dd):");
        for(RentalProduct product : products) {
            if(product.getId() == id) {
                product.setRentDate();
                try{
                    product.setReturnDate(returnDate);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            }
        }
    }
    public static void displayRentedEquipment() {
        System.out.println("\n*********** Rented Equipments ***********");
        products.stream()
                .filter(RentalProduct::isRented)
                .forEach(product -> System.out.println(product));
    }
    public static void displayNotRentedEquipment() {
        System.out.println("\n*********** Available Equipments ***********");
        products.stream()
                .filter(RentalProduct::isAvailable)
                .forEach(product -> System.out.println(product));
    }
}
