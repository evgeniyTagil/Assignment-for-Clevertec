package ru.clevercec.check.util;

import ru.clevercec.check.model.Check;
import ru.clevercec.check.model.OrderItem;

import java.io.FileWriter;
import java.io.IOException;

public class CheckUtils {

    public static void saveCheckToFile(Check check, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Product ID,Description,Quantity,Unit Price,Total Price\n");
            for (OrderItem item : check.getOrderItems()) {
                writer.write(String.format("%d,%s,%d,%.2f,%.2f\n",
                        item.getProduct().getId(),
                        item.getProduct().getDescription(),
                        item.getQuantity(),
                        item.getProduct().getPrice(),
                        item.getTotalCost()));
            }
            writer.write(String.format("Total Amount: %.2f\n", check.getTotalAmountOfProducts()));
            writer.write(String.format("Discount: %.2f%%\n", check.getTotalDiscount()));
            writer.write(String.format("Total Amount After Discount: %.2f\n", check.getTotalAmountAfterDiscount()));
        }
    }

    public static void printCheckToConsole(Check check) {
        System.out.println("Product ID | Description | Quantity | Unit Price | Total Price");
        for (OrderItem item : check.getOrderItems()) {
            System.out.printf("%d | %s | %d | %.2f | %.2f\n",
                    item.getProduct().getId(),
                    item.getProduct().getDescription(),
                    item.getQuantity(),
                    item.getProduct().getPrice(),
                    item.getTotalCost());
        }
        System.out.printf("Total Amount: %.2f\n", check.getTotalAmountOfProducts());
        System.out.printf("Discount: %.2f%%\n", check.getTotalDiscount());
        System.out.printf("Total Amount After Discount: %.2f\n", check.getTotalAmountAfterDiscount());
    }
}