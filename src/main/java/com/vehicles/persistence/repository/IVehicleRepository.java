package com.vehicles.persistence.repository;

import com.vehicles.persistence.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IVehicleRepository extends MongoRepository<Vehicle, String> {
    @Query("{ 'vehicle' : {$regex: ?0} }")
    List<Vehicle> findVehiclesByQuery(String query);
}
