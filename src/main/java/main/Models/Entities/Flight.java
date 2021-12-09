package main.Models.Entities;

import java.util.HashSet;
import java.util.Set;

public class Flight {
    private int Id;
    private String DepartureTime;
    private Route route;
    private Aircraft aircraft;
    private Set<UserMark> UserMarks = new HashSet<>();
    private String Status;

    public Flight(int id) {
        Id = id;
    }

    public Flight(int id, String departureTime, Route route, Aircraft aircraft, Set<UserMark> userMarks, String status) {
        Id = id;
        DepartureTime = departureTime;
        this.route = route;
        this.aircraft = aircraft;
        UserMarks = userMarks;
        Status = status;
    }

    public Flight(){

    }
    public Flight(int id, String departureTime, Route route, Aircraft aircraft, String status) {
        Id = id;
        DepartureTime = departureTime;
        this.route = route;
        this.aircraft = aircraft;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Set<UserMark> getUserMarks() {
        return UserMarks;
    }

    public void setUserMarks(Set<UserMark> userMarks) {
        UserMarks = userMarks;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
