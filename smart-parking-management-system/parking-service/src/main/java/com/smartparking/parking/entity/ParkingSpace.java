package com.smartparking.parking.entity;
public class ParkingSpace {
 private Long id; private Long ownerId; private String spaceNumber; private String location; private String city; private String zone; private double pricePerHour; private String status="AVAILABLE";
 public ParkingSpace(){}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Long getOwnerId(){return ownerId;} public void setOwnerId(Long v){ownerId=v;}
 public String getSpaceNumber(){return spaceNumber;} public void setSpaceNumber(String v){spaceNumber=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;}
 public String getCity(){return city;} public void setCity(String v){city=v;} public String getZone(){return zone;} public void setZone(String v){zone=v;}
 public double getPricePerHour(){return pricePerHour;} public void setPricePerHour(double v){pricePerHour=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
