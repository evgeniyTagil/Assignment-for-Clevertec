package ru.clevercec.check.sevice.impl;

import ru.clevercec.check.model.DiscountCard;
import ru.clevercec.check.sevice.DiscountCardService;
import ru.clevercec.check.util.CsvParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountCardServiceImpl implements DiscountCardService {

    private Map<Integer, DiscountCard> discountCards;

    public DiscountCardServiceImpl(String filePath) throws IOException {
        CsvParser parser = new CsvParser();
        List<DiscountCard> discountCardList = parser.parseDiscountCardsCsv(filePath);
        discountCards = new HashMap<>();
        for (DiscountCard discountCard : discountCardList) {
            discountCards.put(discountCard.getNumberCard(), discountCard);
        }
    }

    @Override
    public DiscountCard getDiscountCardByNumber(int number) {
        return discountCards.get(number);
    }

}
