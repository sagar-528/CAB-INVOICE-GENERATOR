import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository = null;
    Ride[] rides;

    @Before
    public void setUp() throws Exception{
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(2.0, 5, CabRides.NORMAL),
                new Ride(0.1, 1, CabRides.PREMIUM)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }


    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoice() {
        String userId = "A@T.com";
        Ride[] rides = {
                new Ride(2.0, 5, CabRides.NORMAL),
                new Ride(0.1, 1, CabRides.PREMIUM)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
