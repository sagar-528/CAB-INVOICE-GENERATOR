public enum CabRides {
    NORMAL(10.0 , 1.0, 5.0),
    PREMIUM(15.0, 2.0, 20.0);
    private final double MINIMUM_COST_PER_KILOMETER;
    private final double COST_PER_MINUTE;
    private final double MINIMUM_FARE;

     CabRides(double MINIMUM_COST_PER_KILOMETER, double COST_PER_MINUTE, double MINIMUM_FARE) {
        this.MINIMUM_COST_PER_KILOMETER = MINIMUM_COST_PER_KILOMETER;
        this.COST_PER_MINUTE = COST_PER_MINUTE;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }

    public double calCostOfCabRides(Ride ride) {
        double rideCost = ride.distance * MINIMUM_COST_PER_KILOMETER + ride.time * COST_PER_MINUTE;
        return  Math.max(rideCost, MINIMUM_FARE);
    }
}
