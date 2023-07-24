package com.vehicles.web;

import com.vehicles.persistence.model.Vehicle;
import com.vehicles.persistence.model.dto.VehicleDTO;
import com.vehicles.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Vehicle>> findAll() {
        List<Vehicle> foundVehicles = vehicleService.findAll();
        return convertResponse(foundVehicles, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> findVehicle(@PathVariable("id") String id) {
        Vehicle foundVehicle = vehicleService.findVehicle(id);
        return convertResponse(foundVehicle, HttpStatus.OK);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<Vehicle>> findAllByQuery(@RequestParam String query) {
        List<Vehicle> foundVehicles = vehicleService.findVehiclesByQuery(query);
        return convertResponse(foundVehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> insertVehicle(@Valid @RequestBody VehicleDTO vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = "Validation failed: " + bindingResult.getFieldErrors();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }

        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        return convertResponse(createdVehicle, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") String id, @Valid @RequestBody VehicleDTO vehicleToUpdate) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleToUpdate);
        return convertResponse(updatedVehicle, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, String> removeVehicle(@PathVariable("id") String id) {
        vehicleService.deleteVehicle(id);
        return new HashMap<>() {{
            put("message", "Vehicle removed!");
        }};
    }

    private static <T> ResponseEntity<T> convertResponse(T response, HttpStatus status) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(response, responseHeaders, status);
    }
}
