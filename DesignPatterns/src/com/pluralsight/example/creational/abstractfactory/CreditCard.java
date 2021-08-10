package com.pluralsight.example.creational.abstractfactory;

public class CreditCard {

    private Long cardNumber;

    private Integer csvNo;

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCsvNo() {
        return csvNo;
    }

    public void setCsvNo(Integer csvNo) {
        this.csvNo = csvNo;
    }
}
