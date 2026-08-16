package com.smartparking.payment.entity;
public class Payment {
 private Long id; private Long reservationId; private Long userId; private double amount; private String paymentMethod; private String transactionId; private String status="PENDING";
 public Payment(){}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Long getReservationId(){return reservationId;} public void setReservationId(Long v){reservationId=v;}
 public Long getUserId(){return userId;} public void setUserId(Long v){userId=v;} public double getAmount(){return amount;} public void setAmount(double v){amount=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;} public String getTransactionId(){return transactionId;} public void setTransactionId(String v){transactionId=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
