package main.Models.Entities;

public class Route {
    private int Id;
    private String DeparturePoint;
    private String ArrivalPoint;
    private String FlightTime;
    private int Distance;
    public Route(){

    }
    public Route(int id, String departurePoint, String arrivalPoint, String flightTime, int distance) {
        Id = id;
        DeparturePoint = departurePoint;
        ArrivalPoint = arrivalPoint;
        FlightTime = flightTime;
        Distance = distance;
    }

    public String getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(String flightTime) {
        FlightTime = flightTime;
    }

    public String getArrivalPoint() {
        return ArrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        ArrivalPoint = arrivalPoint;
    }

    public String getDeparturePoint() {
        return DeparturePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        DeparturePoint = departurePoint;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }
}
