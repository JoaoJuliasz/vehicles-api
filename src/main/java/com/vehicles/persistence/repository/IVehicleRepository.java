package com.vehicles.persistence.repository;

import com.vehicles.persistence.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IVehicleRepository extends MongoRepository<Vehicle, String> {

    @Query("{}")
    List<Vehicle> findAll();

    Vehicle insert(Vehicle vehicle);

//
//    List<Vehicle> queryVehicles(String query);
//
//    Vehicle createVehicle(Vehicle newVehicle);
//
//    Vehicle updateVehicle(Vehicle updatedVehicle);
//
//    boolean deleteVehicle(String id);

}
