package com.vehicles.persistence.repository;

import com.vehicles.persistence.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVehicleRepository extends MongoRepository<Vehicle, String> {

}
