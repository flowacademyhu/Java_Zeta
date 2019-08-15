import hu.flowacademy.pract.parking.Automobile;
import hu.flowacademy.pract.parking.Bike;
import hu.flowacademy.pract.parking.Parking;
import hu.flowacademy.pract.parking.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {

  Parking<Vehicle> vehicleParking = new Parking<>(300);

  @Test
  public void testAddAuto() {
    vehicleParking.add(new Automobile());
    assertEquals(1, vehicleParking.getAutomobileCount());
  }

  @Test
  public void testAddBike() {
    vehicleParking.add(new Bike());
    assertEquals(1, vehicleParking.getBikeCount());
  }

  @Test
  public void testMaxCount() {
    Parking<Vehicle> vehicleParking = new Parking<>(2);
    vehicleParking.add(new Automobile());
    vehicleParking.add(new Automobile());
    boolean last = vehicleParking.add(new Automobile());
    assertFalse(last);
  }

}
