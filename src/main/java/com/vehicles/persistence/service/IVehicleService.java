package com.vehicles.persistence.service;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {

    List<Vehicle> findAll();

    Vehicle findVehicle(String id);

    Vehicle createVehicle(VehicleDTO newVehicle);

}
