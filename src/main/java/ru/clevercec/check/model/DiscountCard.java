package ru.clevercec.check.model;

public class DiscountCard {
    private int id;
    private int numberCard;
    private int discountAmount;

    public DiscountCard() {
    }

    public DiscountCard(int id, int numberCard, int discountAmount) {
        this.id = id;
        this.numberCard = numberCard;
        this.discountAmount = discountAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
}
