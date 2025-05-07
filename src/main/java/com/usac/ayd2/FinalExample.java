package com.usac.ayd2;

import java.util.List;
import java.util.ArrayList;

public class FinalExample {
    
    public void processData(String input) {
        List<String> data = new ArrayList<>();
        String[] parts = input.split(",");
        for (String part : parts) {
            part = part.trim();
            if (part.length() > 0) {
                if (part.length() > 10) {
                    part = part.substring(0, 10);
                }
                if (part.matches("[a-zA-Z]+")) {
                    data.add(part.toUpperCase());
                }
            }
        }
        
        System.out.println("Data processed:");
        for (String item : data) {
            System.out.println("- " + item);
        }
        
        System.out.println("Total items:");
        for (String item : data) {
            System.out.println("- " + item);
        }
    }
    
    public String createUser(String name, String email, String phone, 
                            String address, String city, String zip) {
        // Validation logic mixed with creation
        if (name == null || name.isEmpty()) {
            return "Name cannot be empty";
        }
        if (email == null || !email.contains("@")) {
            return "Invalid email";
        }
        // ... more validations
        
        return "User created: " + name;
    }
    
    public class Order {
        private String customerName;
        private List<String> items;
        private double total;
        
        public void printOrderSummary() {
            ReportGenerator generator = new ReportGenerator();
            generator.printHeader(customerName);
            for (String item : items) {
                generator.printLineItem(item);
            }
            generator.printTotal(total);
        }
    }
    
    public class ReportGenerator {
        public void printHeader(String customer) {
            System.out.println("Order for: " + customer);
        }
        
        public void printLineItem(String item) {
            System.out.println(" - Item: " + item);
        }
        
        public void printTotal(double total) {
            System.out.println("Total: $" + total);
        }
    }
    
    public double calculateArea(String shape, double... dimensions) {
        switch (shape) {
            case "circle":
                return Math.PI * dimensions[0] * dimensions[0];
            case "rectangle":
                return dimensions[0] * dimensions[1];
            case "triangle":
                return dimensions[0] * dimensions[1] / 2;
            default:
                throw new IllegalArgumentException("Unknown shape");
        }
    }
}