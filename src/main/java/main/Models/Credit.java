package main.Models;

import java.io.Serializable;

public class Credit implements Serializable {
    private int nameId;
    private String nameVal;
    private long creditNumber;
    private String storageTime;
    private double interestRate;
    private String rateType;
    private String responseName;
    private double amount;


    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }


    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }


    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getNameVal() {
        return nameVal;
    }

    public void setNameVal(String nameVal) {
        this.nameVal = nameVal;
    }

    public long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(long creditNumber) {
        this.creditNumber = creditNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "nameId=" + nameId +
                ", nameVal='" + nameVal + '\'' +
                ", creditNumber=" + creditNumber +
                ", storageTime='" + storageTime + '\'' +
                ", interestRate=" + interestRate +
                ", rateType='" + rateType + '\'' +
                ", responseName='" + responseName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
