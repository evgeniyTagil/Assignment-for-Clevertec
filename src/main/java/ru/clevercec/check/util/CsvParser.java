package ru.clevercec.check.util;

import ru.clevercec.check.model.DiscountCard;
import ru.clevercec.check.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public List<Product> parseProductsCsv(String filePath) throws IOException {
        List<Product> productList = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        boolean skipHeader = true;

        for (String fileLine : fileLines) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }

            String[] splitedText = fileLine.split("\\s*,\\s*");

            try {
                int id = Integer.parseInt(splitedText[0].trim());
                String description = splitedText[1].trim();
                double price = Double.parseDouble(splitedText[2].trim().replace("$", ""));
                int qualityInStock = Integer.parseInt(splitedText[3].trim());
                boolean wholesaleProduct = splitedText[4].trim().equals("+");

                Product product = new Product(id, description, price, qualityInStock, wholesaleProduct);
                productList.add(product);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Error parsing line: " + fileLine);
                e.printStackTrace();
            }
        }
        return productList;
    }

    public List<DiscountCard> parseDiscountCardsCsv(String filePath) throws IOException {
        List<DiscountCard> discountCardList = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        boolean skipHeader = true;

        for (String fileLine : fileLines) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }

            String[] splitedText = fileLine.split("\\s*,\\s*");

            try {
                int id = Integer.parseInt(splitedText[0].trim());
                int numberCard = Integer.parseInt(splitedText[1].trim());
                int discountAmount = Integer.parseInt(splitedText[2].trim());

                DiscountCard discountCard = new DiscountCard(id, numberCard, discountAmount);
                discountCardList.add(discountCard);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Error parsing line: " + fileLine);
                e.printStackTrace();
            }
        }
        return discountCardList;
    }
}
