package com.vehicles.web;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;
import com.vehicles.persistence.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public Map<String, List<Vehicle>> findAll() {
        List<Vehicle> foundVehicles = vehicleService.findAll();
        return convertToResponse(foundVehicles);
    }

    @PostMapping
    public Vehicle insertVehicle(@Valid @RequestBody VehicleDTO vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    private static <T> Map<String, List<T>> convertToResponse(List<T> foundVehicles) {
        Map<String, List<T>> response = new HashMap<>() {{
            put("content", foundVehicles);
        }};
        return response;
    }

}
