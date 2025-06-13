package lesson2_3.Task1;

public class Product {
    String ProductName;
    String ProductionDate;
    String Manufacturer;
    String OriginCountry;
    int PriceInDollars;
    String IsItBooked;

    public Product(String ProductName, String ProductionDate, String Manufacturer, String OriginCountry, int PriceInDollars, String IsItBooked) {
        this.ProductName = ProductName;
        this.ProductionDate = ProductionDate;
        this.Manufacturer = Manufacturer;
        this.OriginCountry = OriginCountry;
        this.PriceInDollars = PriceInDollars;
        this.IsItBooked = IsItBooked;

    }

    public static void main(String[] args) {

        Product product1 = new Product("Iphone 5", "24.02.2015", "Apple", "USA",250, "Booked");
        System.out.println(product1.ProductName);
        System.out.println(product1.ProductionDate);
        System.out.println(product1.Manufacturer);
        System.out.println(product1.OriginCountry);
        System.out.println(product1.PriceInDollars);
        System.out.println(product1.IsItBooked);
    }
}

