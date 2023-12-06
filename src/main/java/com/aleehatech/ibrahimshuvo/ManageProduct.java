package com.aleehatech.ibrahimshuvo;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class ManageProduct  {

    public static void writeToFile(Product product) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("products.txt", true))) {
        writer.println(product.getProductId() + "," + product.getName() + "," + product.getPrice()+ "," + product.getQuantity());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static double calculateAveragePrice() {
        double total = 0;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double price = Double.parseDouble(parts[2]);
                total += price;
                count++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return count > 0 ? total / count : 0;
    }

    public static void printLowQuantityProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int quantity = Integer.parseInt(parts[3]);
                if (quantity < 5) {
                    //System.out.println("Low quantity product: " + line);
                    
                    String _id = parts[0];
                    String name = parts[1];
                    String price = parts[2];
                    String quantity_str = parts[3];
                    System.out.println("Product id: "+_id+", name: " + name +", price: "+price +" ,Quantity: "+quantity_str );
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void printProductNames() {
        Map<Integer, String> productIdToName = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int productId = Integer.parseInt(parts[0]);
                String name = parts[1];
                productIdToName.put(productId, name);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println("\nProduct names using hashing:");
        for (String name : productIdToName.values()) {
            System.out.println(name);
        }
    }
    
    public static void printAllProductNames() {
    try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String _id = parts[0];
            String name = parts[1];
            String price = parts[2];
            String quantity = parts[3];
            System.out.println("Product id: "+_id+", name: " + name +", price: "+price +" ,Quantity: "+quantity );
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
}

    
}