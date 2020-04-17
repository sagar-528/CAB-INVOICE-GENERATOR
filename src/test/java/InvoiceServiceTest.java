import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception{
        invoiceService = new InvoiceService();
    }

    @Test
    public void whenGivenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time, Ride.RideType.PREMIUM);
        Assert.assertEquals(40, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time, Ride.RideType.PREMIUM);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
              new Ride(2.0, 5, Ride.RideType.NORMAL),
              new Ride(0.1, 1, Ride.RideType.NORMAL)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoice() {
        String userId = "A@T.com";
        Ride[] rides = {
                new Ride(2.0, 5, Ride.RideType.PREMIUM),
                new Ride(0.1, 1, Ride.RideType.PREMIUM)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
