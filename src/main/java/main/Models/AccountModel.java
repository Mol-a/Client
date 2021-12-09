package main.Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;


public class AccountModel {
    private SimpleStringProperty Deposit_name;
    private SimpleIntegerProperty Storage_time;
    private SimpleDoubleProperty Interest_rate;
    private SimpleStringProperty Rate_type;
    private SimpleStringProperty amount_operation;
    private SimpleStringProperty Responce_name;

    public AccountModel(String deposit_name, int storage_time, double interest_rate, String rate_type, String amount_operation, String responce_name) {
        Deposit_name = new SimpleStringProperty(deposit_name);
        Storage_time = new SimpleIntegerProperty(storage_time);
        Interest_rate = new SimpleDoubleProperty(interest_rate);
        Rate_type = new SimpleStringProperty(rate_type);
        this.amount_operation = new SimpleStringProperty(amount_operation);
        Responce_name = new SimpleStringProperty(responce_name);
    }

    public String getDeposit_name() {
        return Deposit_name.get();
    }

    public SimpleStringProperty deposit_nameProperty() {
        return Deposit_name;
    }

    public int getStorage_time() {
        return Storage_time.get();
    }

    public SimpleIntegerProperty storage_timeProperty() {
        return Storage_time;
    }

    public double getInterest_rate() {
        return Interest_rate.get();
    }

    public SimpleDoubleProperty interest_rateProperty() {
        return Interest_rate;
    }

    public String getRate_type() {
        return Rate_type.get();
    }

    public SimpleStringProperty rate_typeProperty() {
        return Rate_type;
    }


    public String getResponce_name() {
        return Responce_name.get();
    }

    public SimpleStringProperty responce_nameProperty() {
        return Responce_name;
    }

    public void setDeposit_name(String deposit_name) {
        this.Deposit_name.set(deposit_name);
    }

    public void setStorage_time(int storage_time) {
        this.Storage_time.set(storage_time);
    }

    public void setInterest_rate(double interest_rate) {
        this.Interest_rate.set(interest_rate);
    }

    public void setRate_type(String rate_type) {
        this.Rate_type.set(rate_type);
    }

    public void setResponce_name(String responce_name) {
        this.Responce_name.set(responce_name);
    }

    public String getAmount_operation() {
        return amount_operation.get();
    }

    public void setAmount_operation(String amount_operation) {
        this.amount_operation.set(amount_operation);
    }


}