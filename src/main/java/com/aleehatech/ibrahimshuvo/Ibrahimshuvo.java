package com.aleehatech.ibrahimshuvo;

public class Ibrahimshuvo {

    public static void main(String[] args) {
        // Example usage
        Product product1 = new Product(2, "Iphone 15 pro", 120000, 5);
        Product product2 = new Product(1, "Iphone Xs", 29000, 100);
        Product product3 = new Product(3, "Poco X3", 50000, 2);

        ManageProduct mp = new ManageProduct(); // Instantiate the ManageProduct class

        mp.writeToFile(product1);
        mp.writeToFile(product2);
        mp.writeToFile(product3);
        
        System.out.println("Printing all product names: ");
        mp.printAllProductNames();


        System.out.println("\nAverage price: " + String.format("%.2f", mp.calculateAveragePrice()) );

        System.out.println("\nLow quantity products:");
        mp.printLowQuantityProducts();

        mp.printProductNames();
    }
}
