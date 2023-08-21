package com.techforb.userdashboard.dto;

import com.techforb.userdashboard.model.Transaction;


import java.time.LocalDateTime;

public class TransactionDTO {

    private long id;

    private String destinationAccount;

    private double amount;

    private LocalDateTime date;



    public TransactionDTO() {

    }

    public TransactionDTO(Transaction transaction) {

        this.id = transaction.getId();
        this.destinationAccount = transaction.getCvu();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
