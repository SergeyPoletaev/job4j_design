package ru.job4j.lsp.parking;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarAndTruckParkingTest {

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

    @Test
    public void whenParkingCapacity2CarAnd1TruckThenAccept1TruckWithSize2And1Truck() {
        Parking parking = new CarAndTruckParking(2, 1);
        Vehicle kamaz = new Truck(2);
        Vehicle belaz = new Truck(10);
        parking.park(belaz);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(belaz, kamaz)));
    }

    @Test
    public void whenParkingCapacity2CarAnd0TruckThenAccept1CarAnd0Truck() {
        Parking parking = new CarAndTruckParking(2, 0);
        Vehicle volga = new Car();
        Vehicle kamaz = new Truck(2);
        parking.park(volga);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(volga)));
    }

    @Test
    public void whenParkingCapacity0CarAnd1TruckThenAccept0CarAnd1Truck() {
        Parking parking = new CarAndTruckParking(0, 1);
        Vehicle volga = new Car();
        Vehicle kamaz = new Truck(2);
        parking.park(volga);
        parking.park(kamaz);
        assertThat(parking.findAll(), is(List.of(kamaz)));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenTruckSizeLessThenTwoThenEx() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Размер грузового автомобиля должен быть более 1"));
        Parking parking = new CarAndTruckParking(2, 1);
        Vehicle kamaz = new Truck(1);
    }

}