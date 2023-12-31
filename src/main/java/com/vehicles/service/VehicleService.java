package com.vehicles.service;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;
import com.vehicles.persistence.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findVehicle(String id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vehicle with id '" + id + "' not found"));
    }

    public List<Vehicle> findVehiclesByQuery(String query) {
        return vehicleRepository.findVehiclesByQuery(query);
    }

    public Vehicle createVehicle(VehicleDTO newVehicle) {
        Vehicle vehicle = new Vehicle(newVehicle, LocalDate.now(), LocalDate.now());
        return vehicleRepository.insert(vehicle);
    }

    public Vehicle updateVehicle(String id, VehicleDTO updatedVehicle) {
        Vehicle vehicleToUpdate = findVehicle(id);
        vehicleToUpdate.update(updatedVehicle);
        return vehicleRepository.save(vehicleToUpdate);
    }

    public void deleteVehicle(String id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle with id '" + id + "' not found");
        }
        vehicleRepository.deleteById(id);
    }
}
