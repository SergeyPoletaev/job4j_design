package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarAndTruckParking implements Parking {
    private int placeCar;
    private int placeTruck;
    private final List<Vehicle> cars;
    private final List<Vehicle> trucks;

    public CarAndTruckParking(int placeCar, int placeTruck) {
        this.placeCar = placeCar;
        this.placeTruck = placeTruck;
        this.cars = new ArrayList<>(placeCar);
        this.trucks = new ArrayList<>(placeTruck);
    }

    @Override
    public boolean park(Vehicle vehicle) {
        int vehicleSize = vehicle.getSize();
        boolean rsl = false;
        if (vehicleSize == Size.ONE.getValue() && placeCar > 0) {
            cars.add(vehicle);
            placeCar--;
            rsl = true;
        } else if (vehicleSize > Size.ONE.getValue() && placeTruck > 0) {
            trucks.add(vehicle);
            placeTruck--;
            rsl = true;
        } else if (vehicleSize > Size.ONE.getValue() && placeCar >= vehicleSize) {
            trucks.add(vehicle);
            placeCar -= vehicleSize;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> rsl = new ArrayList<>(cars);
        rsl.addAll(trucks);
        return rsl;
    }
}
