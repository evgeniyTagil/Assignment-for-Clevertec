package ru.clevercec.check.sevice;

import ru.clevercec.check.model.Check;
import ru.clevercec.check.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    Check createCheck(List<OrderItem> orderItems, int discountCardNumber);
    List<OrderItem> createOrderItems(List<String> idQuantities);
}
