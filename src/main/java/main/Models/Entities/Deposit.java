package main.Models.Entities;

public class Deposit {
    private int id;
    private int deposit_number;
    private String deposit_name;
    private int storage_time;
    private double interest_rate;
    private String rate_type;
    private String amount_operation;
    private String responce_name;
    private Account account;

    public Deposit(){}

    public Deposit(int id, int deposit_number, String deposit_name, int storage_time, double interest_rate, String rate_type, String amount_operation, String responce_name, Account account) {
        this.id = id;
        this.deposit_number = deposit_number;
        this.deposit_name = deposit_name;
        this.storage_time = storage_time;
        this.interest_rate = interest_rate;
        this.rate_type = rate_type;
        this.amount_operation = amount_operation;
        this.responce_name = responce_name;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeposit_number() {
        return deposit_number;
    }

    public void setDeposit_number(int deposit_number) {
        this.deposit_number = deposit_number;
    }

    public String getDeposit_name() {
        return deposit_name;
    }

    public void setDeposit_name(String deposit_name) {
        this.deposit_name = deposit_name;
    }

    public int getStorage_time() {
        return storage_time;
    }

    public void setStorage_time(int storage_time) {
        this.storage_time = storage_time;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public String getRate_type() {
        return rate_type;
    }

    public void setRate_type(String rate_type) {
        this.rate_type = rate_type;
    }

    public String getAmount_operation() {
        return amount_operation;
    }

    public void setAmount_operation(String ammount_operation) {
        this.amount_operation = ammount_operation;
    }

    public String getResponce_name() {
        return responce_name;
    }

    public void setResponce_name(String responce_name) {
        this.responce_name = responce_name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
