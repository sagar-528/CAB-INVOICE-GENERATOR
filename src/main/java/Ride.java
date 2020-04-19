public class Ride {

    public int time;
    public double distance;
    public CabRides cabRides;

    public Ride( double distance, int time, CabRides cabRides) {
        this.time = time;
        this.distance = distance;
        this.cabRides = cabRides;
    }
}
