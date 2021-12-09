package main.Models.Entities;

public class Passenger {
    private int Id;
    private String FullName;
    private int PlaceNumber;
    private PersonData personData;
    private Flight flight;
    public Passenger(){

    }
    public Passenger(int id, String fullName, int placeNumber,PersonData personData,Flight flight) {
        Id = id;
        FullName = fullName;
        PlaceNumber = placeNumber;
        this.personData = personData;
        this.flight = flight;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getPlaceNumber() {
        return PlaceNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        PlaceNumber = placeNumber;
    }

    public PersonData getPersonData() {
        return personData;
    }

    public void setPersonData(PersonData personData) {
        this.personData = personData;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
