package main.Models.Entities;

public class UserMark {
    private User user;
    private Flight flight;
    private int Mark;
    private int Id;

    public UserMark(main.Models.Entities.User user, main.Models.Entities.Flight flight, int mark) {
        this.user = user;
        this.flight = flight;
        Mark = mark;
    }

    public UserMark(){

    }
    public UserMark(User user, Flight flight, int mark, int id) {
        this.user = user;
        this.flight = flight;
        Mark = mark;
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
