package com.vehicles.persistence.service;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;
import com.vehicles.persistence.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle createVehicle(VehicleDTO newVehicle) {
        Vehicle vehicle = new Vehicle(newVehicle, LocalDate.now(), LocalDate.now());
        return vehicleRepository.insert(vehicle);
    }
}
