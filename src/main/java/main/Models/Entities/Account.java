package main.Models.Entities;

import java.util.HashSet;
import java.util.Set;

public class Account {
    private int id;
    private int account_number;
    private double amount;
    private String open_date;
    private String close_date;
    private Client client;
    private Set<Deposit> deposits = new HashSet<>();
    private Set<Card> cards = new HashSet<>();

    public Account(){}

    public Account(int id, int account_number, double amount, String open_date, String close_date, Client client, Set<Deposit> deposits, Set<Card> cards) {
        this.id = id;
        this.account_number = account_number;
        this.amount = amount;
        this.open_date = open_date;
        this.close_date = close_date;
        this.client = client;
        this.deposits = deposits;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOpen_date() {
        return open_date;
    }

    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    public String getClose_date() {
        return close_date;
    }

    public void setClose_date(String close_date) {
        this.close_date = close_date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
