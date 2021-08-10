package com.pluralsight.example.creational.abstractfactory;

public class CreditCardFactoryDemo {
    public static void main(String[] args) {
        CreditCardFactory creditCardFactory = CardFactory.getCreditCardFactory(500);
        System.out.println(creditCardFactory.getClass());

        CreditCard creditCard = creditCardFactory.getCreditCard(CardType.GOLD);
        System.out.println(creditCard.getClass());
    }
}
