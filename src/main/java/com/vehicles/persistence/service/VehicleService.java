package com.vehicles.persistence.service;

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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle with id '" + id + "' not found"));
    }

    public Vehicle createVehicle(VehicleDTO newVehicle) {
        Vehicle vehicle = new Vehicle(newVehicle, LocalDate.now(), LocalDate.now());
        return vehicleRepository.insert(vehicle);
    }

    public Vehicle updateVehicle(String id, Vehicle updatedVehicle) {
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
