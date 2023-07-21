package com.vehicles.web;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;
import com.vehicles.persistence.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @PostMapping
    public Vehicle insertVehicle(@RequestBody VehicleDTO vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

}
