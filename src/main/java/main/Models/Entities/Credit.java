package main.Models.Entities;

public class Credit {
    private int id;
    private double averageAccount;
    private int creditLoans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAverageAccount() {
        return averageAccount;
    }

    public void setAverageAccount(double average_account) {
        this.averageAccount = average_account;
    }

    public int getCreditLoans() {
        return creditLoans;
    }

    public void setCreditLoans(int creditLoans) {
        this.creditLoans = creditLoans;
    }
}
