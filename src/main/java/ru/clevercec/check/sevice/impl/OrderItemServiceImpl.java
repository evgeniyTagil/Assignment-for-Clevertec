package ru.clevercec.check.sevice.impl;

import ru.clevercec.check.model.Check;
import ru.clevercec.check.model.DiscountCard;
import ru.clevercec.check.model.OrderItem;
import ru.clevercec.check.model.Product;
import ru.clevercec.check.sevice.DiscountCardService;
import ru.clevercec.check.sevice.OrderItemService;
import ru.clevercec.check.sevice.ProductService;

import java.util.ArrayList;
import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    private ProductService productService;
    private DiscountCardService discountCardService;

    public OrderItemServiceImpl(ProductService productService, DiscountCardService discountCardService) {
        this.productService = productService;
        this.discountCardService = discountCardService;
    }

    @Override
    public Check createCheck(List<OrderItem> orderItems, int discountCardNumber) {
        double totalAmountOfProducts = 0;
        double totalAmountAfterDiscount = 0;
        int totalDiscount = 0;

        DiscountCard discountCard = discountCardService.getDiscountCardByNumber(discountCardNumber);

        for (OrderItem item : orderItems) {
            Product product = item.getProduct();
            double itemTotalCost = product.getPrice() * item.getQuantity();

            if (product.isWholesaleProduct() && item.getQuantity() >= 5) {
                itemTotalCost *= 0.9;
            } else if (discountCard != null) {
                itemTotalCost *= (1 - discountCard.getDiscountAmount() / 100.0);
            }

            totalAmountOfProducts += itemTotalCost;
        }

        if (discountCard != null) {
            totalDiscount = discountCard.getDiscountAmount();
            totalAmountAfterDiscount = totalAmountOfProducts * (1 - totalDiscount / 100.0);
        } else {
            totalAmountAfterDiscount = totalAmountOfProducts;
        }

        return new Check(orderItems, totalAmountOfProducts, totalDiscount, totalAmountAfterDiscount);
    }

    @Override
    public List<OrderItem> createOrderItems(List<String> idQuantities) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (String idQuantity : idQuantities) {
            String[] parts = idQuantity.split("-");
            int id = Integer.parseInt(parts[0]);
            int quantity = Integer.parseInt(parts[1]);

            Product product = productService.getProductById(id);
            if (product != null) {
                orderItems.add(new OrderItem(product, quantity));
            }
        }
        return orderItems;
    }
}
