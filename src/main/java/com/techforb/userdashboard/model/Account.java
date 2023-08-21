package com.techforb.userdashboard.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String CVU;

    private LocalDateTime creation_date;

    private double balance;

    @OneToMany(mappedBy="account", fetch=FetchType.EAGER)
    private Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy="account",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Card> cards = new HashSet<>();


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public Account() {
    }

    public Account(String CVU, LocalDateTime creation_date, double balance) {
        this.CVU = CVU;
        this.creation_date = creation_date;
        this.balance = balance;
    }


    public long getId() {
        return id;
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

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCard(Card card){
        card.setAccount(this);
        cards.add(card);
    }

    public void addTransaction(Transaction transaction){
        transaction.setAccount(this);
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", CVU='" + CVU + '\'' +
                ", creation_date=" + creation_date +
                ", balance=" + balance +
                ", transactions=" + transactions +
                ", cards=" + cards +
                ", user=" + user +
                '}';
    }
}
