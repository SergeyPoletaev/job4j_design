package ru.job4j.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarAndTruckParkingTest {

    @Ignore
    @Test
    public void whenParkingCapacity2CarAnd1TruckThenAccept2CarAnd1Truck() {
        Parking parking = new CarAndTruckParking(2, 1);
        Vehicle volga = new Car();
        Vehicle pobeda = new Car();
        Vehicle kamaz = new Truck(10);
        parking.park(volga);
        parking.park(pobeda);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(volga, pobeda, kamaz)));
    }

    @Ignore
    @Test
    public void whenParkingCapacity2CarAnd1TruckThenAccept1TruckWithSize2And1Truck() {
        Parking parking = new CarAndTruckParking(2, 1);
        Vehicle kamaz = new Truck(2);
        Vehicle belaz = new Truck(10);
        parking.park(belaz);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(belaz, kamaz)));
    }

    @Ignore
    @Test
    public void whenParkingCapacity2CarAnd0TruckThenAccept1CarAnd0Truck() {
        Parking parking = new CarAndTruckParking(2, 0);
        Vehicle volga = new Car();
        Vehicle kamaz = new Truck(2);
        parking.park(volga);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(volga)));
    }

    @Ignore
    @Test
    public void whenParkingCapacity0CarAnd1TruckThenAccept0CarAnd1Truck() {
        Parking parking = new CarAndTruckParking(0, 1);
        Vehicle volga = new Car();
        Vehicle kamaz = new Truck(2);
        parking.park(volga);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(kamaz)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTruckSizeLessThenTwoThenEx() {
        Parking parking = new CarAndTruckParking(2, 1);
        Vehicle kamaz = new Truck(1);
    }
}