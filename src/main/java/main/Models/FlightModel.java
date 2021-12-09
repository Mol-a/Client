package main.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FlightModel {
    private SimpleStringProperty Route;
    private SimpleStringProperty Aircraft;
    private SimpleStringProperty DepartureTime;
    private SimpleStringProperty Status;
    private SimpleIntegerProperty Id;

    public FlightModel(String route, String aircraft, String departureTime, String status, int id) {
        Route = new SimpleStringProperty(route);
        Aircraft = new SimpleStringProperty(aircraft);
        DepartureTime = new SimpleStringProperty(departureTime);
        Status = new SimpleStringProperty(status);
        Id =  new SimpleIntegerProperty(id);
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

    public String getAircraft() {
        return Aircraft.get();
    }

    public SimpleStringProperty aircraftProperty() {
        return Aircraft;
    }

    public void setAircraft(String aircraft) {
        this.Aircraft.set(aircraft);
    }

    public String getDepartureTime() {
        return DepartureTime.get();
    }

    public SimpleStringProperty departureTimeProperty() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.DepartureTime.set(departureTime);
    }

    public String getStatus() {
        return Status.get();
    }

    public SimpleStringProperty statusProperty() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }

    public int getId() {
        return Id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return Id;
    }

    public void setId(int id) {
        this.Id.set(id);
    }
}
