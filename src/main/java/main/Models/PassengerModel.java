package main.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty; //для заполнения таблиц
import main.Models.Entities.UserMark;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Set;

public class PassengerModel {
    private SimpleStringProperty Route;
    private SimpleStringProperty User;
    private SimpleStringProperty Place;
    private SimpleStringProperty Mark;

    public PassengerModel(String route, String user, int place, int mark) {
        Route = new SimpleStringProperty(route);
        User = new SimpleStringProperty(user);
        Place = new SimpleStringProperty(String.valueOf(place));
        Mark = new SimpleStringProperty(String.valueOf(mark));
    }

    public String getUser() {
        return User.get();
    }

    public SimpleStringProperty userProperty() {
        return User;
    }

    public void setUser(String user) {
        this.User.set(user);
    }

    public String getRoute() {
        return Route.get();
    }

    public SimpleStringProperty routeProperty() {
        return Route;
    }

    public void setRoute(String route) {
        this.Route.set(route);
    }

    public String getPlace() {
        return Place.get();
    }

    public SimpleStringProperty placeProperty() {
        return Place;
    }

    public void setPlace(String place) {
        this.Place.set(place);
    }

    public String getMark() {return Mark.get();}

    public void setMark(String mark) {this.Mark.set(mark);}

    public SimpleStringProperty markProperty() {return Mark;}
}