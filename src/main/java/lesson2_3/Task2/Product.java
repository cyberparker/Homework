package lesson2_3.Task2;

import org.w3c.dom.ls.LSOutput;

public class Product {
    String ProductName;
    String ProductionDate;
    String Manufacturer;
    String OriginCountry;
    int PriceInDollars;
    String IsItBooked;

    public static void main(String[] args) {

    }

    Product[] productsArray = new Product[5];

    {
        productsArray[0] = new Product("Samsung S25 Ultra", "22.10.24", "Samsung corp", "Korea", 699, "Not booked");
        productsArray[1] = new Product("Xiaomi Redmi note 5", "22.10.17", "Xiaomi", "China", 239, "Booked");
        productsArray[2] = new Product("Apple iPhone 11", "10.09.19", "Apple", "USA", 349, "Booked");
        productsArray[3] = new Product("Google Pixel 9", "13.08.24", "Google", "China", 799, "not booked");
        productsArray[4] = new Product("Moto G 5G Ace", "13.01.21", "Motorola Mobility", "China", 119, "Booked");
    }

    public Product(String ProductName, String ProductionDate, String Manufacturer, String OriginCountry, int PriceInDollars, String IsItBooked) {
        this.ProductName = ProductName;
        this.ProductionDate = ProductionDate;
        this.Manufacturer = Manufacturer;
        this.OriginCountry = OriginCountry;
        this.PriceInDollars = PriceInDollars;
        this.IsItBooked = IsItBooked;
    }


}