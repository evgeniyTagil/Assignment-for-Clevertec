package ru.clevercec.check.sevice.impl;

import ru.clevercec.check.model.DiscountCard;
import ru.clevercec.check.model.Product;
import ru.clevercec.check.sevice.ProductService;
import ru.clevercec.check.util.CsvParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products;

    public ProductServiceImpl(String filePath) throws IOException {
        CsvParser parser = new CsvParser();
        List<Product> productList = parser.parseProductsCsv(filePath);
        products = new HashMap<>();
        for (Product product : productList) {
            products.put(product.getId(), product);
        }
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }
}
