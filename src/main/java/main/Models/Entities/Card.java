package main.Models.Entities;

public class Card {
    private int id;
    private int card_number;
    private String client_name;
    private String client_surname;
    private int period;
    private int CVV;
    private int card_amount;
    Account account;

    public Card(){}

    public Card(int id, int card_number, String client_name, String client_surname, int period, int CVV, int card_amount, Account account) {
        this.id = id;
        this.card_number = card_number;
        this.client_name = client_name;
        this.client_surname = client_surname;
        this.period = period;
        this.CVV = CVV;
        this.card_amount = card_amount;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_surname() {
        return client_surname;
    }

    public void setClient_surname(String client_surname) {
        this.client_surname = client_surname;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCVV() {
        return CVV;
    }

    public int getCard_amount() {
        return card_amount;
    }

    public void setCard_amount(int card_amount) {
        this.card_amount = card_amount;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
