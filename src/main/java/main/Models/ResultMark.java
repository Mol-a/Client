package main.Models;


import main.Models.Entities.Flight;

public class ResultMark implements Comparable<Object> {
    private int positionValue;
    private double averageMark;
    private Flight flight;

    public ResultMark(int positionValue, Flight flight) {
        this.positionValue = positionValue;
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(int positionValue) {
        this.positionValue = positionValue;
    }

    @Override
    public int compareTo(Object o) {
        ResultMark mark = (ResultMark)o;
        return mark.positionValue-this.positionValue;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
