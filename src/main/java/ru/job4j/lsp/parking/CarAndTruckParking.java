package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarAndTruckParking implements Parking {
    private int placeCar;
    private int placeTruck;
    private final List<Vehicle> cars = new ArrayList<>();
    private final List<Vehicle> trucks = new ArrayList<>();

    public CarAndTruckParking(int placeCar, int placeTruck) {
        this.placeCar = placeCar;
        this.placeTruck = placeTruck;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return true;
    }

    @Override
    public List<Vehicle> findAll() {
        return null;
    }
}
