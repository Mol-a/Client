package main.Models.Entities;

import java.util.HashSet;
import java.util.Set;

public class Aircraft {
    private int Id;
    private String Name;
    private String Type;
    private int SeatsAmount;
    private int BusinessSeatsAmount;
    private Set<Flight> Flights = new HashSet<>(0);

    public Aircraft(int id, String name, String type, int seatsAmount, int businessSeatsAmount) {
        Id = id;
        Name = name;
        Type = type;
        SeatsAmount = seatsAmount;
        BusinessSeatsAmount = businessSeatsAmount;
    }
    public Aircraft(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getSeatsAmount() {
        return SeatsAmount;
    }

    public void setSeatsAmount(int seatsAmount) {
        SeatsAmount = seatsAmount;
    }

    public int getBusinessSeatsAmount() {
        return BusinessSeatsAmount;
    }

    public void setBusinessSeatsAmount(int businessSeatsAmount) {
        BusinessSeatsAmount = businessSeatsAmount;
    }

    public Set<Flight> getFlights() {
        return Flights;
    }

    public void setFlights(Set<Flight> flights) {
        Flights = flights;
    }
}
