package com.smartparking.vehicle.entity;
public class Vehicle {
    private Long id; private Long userId; private String vehicleNumber;
    private String vehicleType; private String brand; private String model; private String color;
    private String status = "PARKED_OUTSIDE";
    public Vehicle() {}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getUserId(){return userId;} public void setUserId(Long v){userId=v;}
    public String getVehicleNumber(){return vehicleNumber;} public void setVehicleNumber(String v){vehicleNumber=v;}
    public String getVehicleType(){return vehicleType;} public void setVehicleType(String v){vehicleType=v;}
    public String getBrand(){return brand;} public void setBrand(String v){brand=v;}
    public String getModel(){return model;} public void setModel(String v){model=v;}
    public String getColor(){return color;} public void setColor(String v){color=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
