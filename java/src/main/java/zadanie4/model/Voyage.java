package zadanie4.model;

public class Voyage {
    private VoyageType type;
    private TransportType transportType;
    private Byte duration;
    private Boolean mealIncluded;

    public Voyage() {
    }

    public Voyage(VoyageType type, TransportType transportType, Byte duration, Boolean mealIncluded) {
        this.type = type;
        this.transportType = transportType;
        this.duration = duration;
        this.mealIncluded = mealIncluded;
    }

    public VoyageType getType() {
        return type;
    }

    public void setType(VoyageType type) {
        this.type = type;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Byte getDuration() {
        return duration;
    }

    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    public Boolean getMealIncluded() {
        return mealIncluded;
    }

    public void setMealIncluded(Boolean mealIncluded) {
        this.mealIncluded = mealIncluded;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "type=" + type +
                ", transportType=" + transportType +
                ", duration=" + duration +
                ", mealIncluded=" + mealIncluded +
                '}';
    }
}
