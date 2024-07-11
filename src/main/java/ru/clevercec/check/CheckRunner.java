package ru.clevercec.check;


import ru.clevercec.check.model.Check;
import ru.clevercec.check.model.OrderItem;
import ru.clevercec.check.sevice.DiscountCardService;
import ru.clevercec.check.sevice.OrderItemService;
import ru.clevercec.check.sevice.ProductService;
import ru.clevercec.check.sevice.impl.DiscountCardServiceImpl;
import ru.clevercec.check.sevice.impl.OrderItemServiceImpl;
import ru.clevercec.check.sevice.impl.ProductServiceImpl;
import ru.clevercec.check.util.CheckUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckRunner {
    public static void main(String[] args) throws IOException {
        try {
            ProductService productService = new ProductServiceImpl("C:\\Users\\user\\IdeaProjects\\AssignmentforClevertec\\src\\main\\resources\\products.csv");
            DiscountCardService discountCardService = new DiscountCardServiceImpl("C:\\Users\\user\\IdeaProjects\\AssignmentforClevertec\\src\\main\\resources\\discountCards.csv");

            OrderItemService orderService = new OrderItemServiceImpl(productService, discountCardService);

            List<String> argList = new ArrayList<>(Arrays.asList(args));

            if (args.length < 2) {
                throw new IllegalArgumentException("Недостаточно аргументов");
            }

            List<String> idQuantities = argList.subList(0, args.length - 2);

            int discountCardNumber = Integer.parseInt(args[args.length - 2].split("=")[1]);
            double balanceDebitCard = Double.parseDouble(args[args.length - 1].split("=")[1]);

            List<OrderItem> orderItems = orderService.createOrderItems(idQuantities);

            Check check = orderService.createCheck(orderItems, discountCardNumber);

            CheckUtils.saveCheckToFile(check, "./result.csv");
            CheckUtils.printCheckToConsole(check);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}