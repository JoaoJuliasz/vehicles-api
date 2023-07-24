package com.vehicles.persistence.model.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class VehicleDTO {

    @Id
    private String id;
    @NotNull(message = "vehicle is required")
    private String vehicle;
    @NotNull(message = "brand is required")
    private String brand;
    @NotNull(message = "description is required")
    private String description;
    @NotNull(message = "year is required")
    private int year;
    @NotNull(message = "sold is required")
    private boolean sold;


    public VehicleDTO(String id, String vehicle, String brand, String description, int year, boolean sold) {
        this.id = id;
        this.vehicle = vehicle;
        this.brand = brand;
        this.description = description;
        this.year = year;
        this.sold = sold;
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
}
