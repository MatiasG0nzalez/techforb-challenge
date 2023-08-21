package com.techforb.userdashboard.dto;

import com.techforb.userdashboard.model.Account;
import com.techforb.userdashboard.model.Card;
import com.techforb.userdashboard.model.Transaction;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {

    private long id;

    private String CVU;

    private LocalDateTime creation_date;

    private double balance;

    private Set<TransactionDTO> transactions;

    private Set<CardDTO> cards;

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.CVU = account.getCVU();
        this.creation_date = account.getCreation_date();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toSet());
        this.cards = account.getCards().stream().map(CardDTO::new).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCVU() {
        return CVU;
    }

    public void setCVU(String CVU) {
        this.CVU = CVU;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public Set<CardDTO> getCards() {
        return cards;
    }

    public void setCards(Set<CardDTO> cards) {
        this.cards = cards;
    }
}
