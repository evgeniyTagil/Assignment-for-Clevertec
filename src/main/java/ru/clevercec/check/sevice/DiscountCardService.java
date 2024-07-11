package ru.clevercec.check.sevice;

import ru.clevercec.check.model.DiscountCard;

public interface DiscountCardService {

    DiscountCard getDiscountCardByNumber(int number);
}
