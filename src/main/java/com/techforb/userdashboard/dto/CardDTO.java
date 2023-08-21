package com.techforb.userdashboard.dto;

import com.techforb.userdashboard.model.Card;
import com.techforb.userdashboard.model.CardType;

import java.time.LocalDate;

public class CardDTO {

    private long id;

    private String cardHolderName;

    private String cardNumber;

    private LocalDate expirationDate;

    private int cvv;

    private CardType cardType;

    public CardDTO(Card card) {
        this.id = card.getId();
        this.cardHolderName = card.getCardHolderName();
        this.cardNumber = card.getCardNumber();
        this.expirationDate = card.getExpirationDate();
        this.cvv = card.getCvv();
        this.cardType = card.getCardType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
