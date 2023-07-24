package com.vehicles.web;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;
import com.vehicles.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping(value = "/{id}")
    public Vehicle findVehicle(@PathVariable("id") String id) {
        Vehicle foundVehicle = vehicleService.findVehicle(id);
        return foundVehicle;

    }

    @GetMapping(value = "/find")
    public Map<String, List<Vehicle>> findAllByQuery(@RequestParam String query) {
        List<Vehicle> foundVehicles = vehicleService.findVehiclesByQuery(query);
        return convertToResponse(foundVehicles);
    }

    @PostMapping
    public Vehicle insertVehicle(@Valid @RequestBody VehicleDTO vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = "Validation failed: " + bindingResult.getFieldErrors();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
        return vehicleService.createVehicle(vehicle);
    }

    @PutMapping(value = "/{id}")
    public Vehicle updateVehucle(@PathVariable("id") String id, @Valid @RequestBody VehicleDTO updatedVehicle) {
        return vehicleService.updateVehicle(id, updatedVehicle);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, String> removeVehicle(@PathVariable("id") String id) {
        vehicleService.deleteVehicle(id);
        Map deleteSuccess = new HashMap<>() {{
            put("message", "Vehicle removed!");
        }};
        return deleteSuccess;
    }

    private static <T> Map<String, List<T>> convertToResponse(List<T> foundVehicles) {
        Map<String, List<T>> response = new HashMap<>() {{
            put("content", foundVehicles);
        }};
        return response;
    }

}
