package com.vehicles.persistence.model;

import com.vehicles.persistence.model.dto.VehicleDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("vehicles")
public class Vehicle {

    @Id
    private String id;
    private String vehicle;
    private String brand;
    private String description;
    private int year;
    private boolean sold;
    private LocalDate created;
    private LocalDate updated;

    public Vehicle() {

    }

    public Vehicle(String id, String vehicle, String brand, String description, int year, boolean sold, LocalDate created, LocalDate updated) {
        this.id = id;
        this.vehicle = vehicle;
        this.brand = brand;
        this.description = description;
        this.year = year;
        this.sold = sold;
        this.created = created;
        this.updated = updated;
    }

    public Vehicle(VehicleDTO vehicleDTO, LocalDate created, LocalDate updated) {
        this(vehicleDTO.getId(),
                vehicleDTO.getVehicle(),
                vehicleDTO.getBrand(), vehicleDTO.getDescription(),
                vehicleDTO.getYear(), vehicleDTO.isSold(), created, updated);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public void update(VehicleDTO updatedVehicle) {
        this.setVehicle(updatedVehicle.getVehicle());
        this.setBrand(updatedVehicle.getBrand());
        this.setDescription(updatedVehicle.getDescription());
        this.setYear(updatedVehicle.getYear());
        this.setSold(updatedVehicle.isSold());
        this.setUpdated(LocalDate.now());
    }
}
