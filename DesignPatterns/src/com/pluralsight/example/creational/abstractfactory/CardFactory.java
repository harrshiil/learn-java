package com.pluralsight.example.creational.abstractfactory;

public abstract class CardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore) {
        if (creditScore > 600) {
            return new AmexFactory();
        } else {
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);
}
