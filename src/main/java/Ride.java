public class Ride {

    public int time;
    public double distance;
    public enum RideType {NORMAL, PREMIUM};
    public RideType rideType;

    public Ride( double distance, int time, RideType rideType) {
        this.time = time;
        this.distance = distance;
        this.rideType = rideType;
    }
}
