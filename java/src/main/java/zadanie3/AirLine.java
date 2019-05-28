package zadanie3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

public class AirLine {
    private String destination;
    private String flightNumber;
    private String planeType;
    private LocalTime timeStart;
    private Set<DayOfWeek> dayOfWeeks;

    public AirLine() {
    }

    public AirLine(String destination, String flightNumber, String planeType, LocalTime timeStart, Set<DayOfWeek> dayOfWeeks) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.timeStart = timeStart;
        this.dayOfWeeks = dayOfWeeks;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public Set<DayOfWeek> getDayOfWeeks() {
        return dayOfWeeks;
    }

    public void setDayOfWeeks(Set<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    @Override
    public String toString() {
        return "AirLine{" +
                "destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", planeType='" + planeType + '\'' +
                ", timeStart=" + timeStart +
                ", dayOfWeeks=" + dayOfWeeks +
                '}';
    }
}
