package com.vehicles.service;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {

    List<Vehicle> findAll();

    Vehicle findVehicle(String id);

    List<Vehicle> findVehiclesByQuery(String query);

    Vehicle createVehicle(VehicleDTO newVehicle);

    Vehicle updateVehicle(String id, VehicleDTO updatedVehicle);
}
