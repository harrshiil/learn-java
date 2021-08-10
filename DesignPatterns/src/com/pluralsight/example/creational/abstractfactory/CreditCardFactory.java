package com.pluralsight.example.creational.abstractfactory;

public class CreditCardFactory extends CardFactory {


    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new GoldCreditCard();

            case PLATINUM:
                return new PlatinumCreditCard();
            default:
                return null;
        }
    }
}
