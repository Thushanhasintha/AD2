package com.smartparking.payment.controller;
import com.smartparking.payment.entity.Payment; import com.smartparking.payment.service.PaymentService;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/payments")
public class PaymentController {
 private final PaymentService s; public PaymentController(PaymentService s){this.s=s;}
 @PostMapping public ResponseEntity<Payment> pay(@RequestBody Payment p){return ResponseEntity.status(HttpStatus.CREATED).body(s.pay(p));}
 @GetMapping public List<Payment> all(){return s.all();}
 @GetMapping("/{id}") public Payment get(@PathVariable Long id){return s.get(id);}
 @GetMapping("/user/{userId}") public List<Payment> byUser(@PathVariable Long userId){return s.byUser(userId);}
 @GetMapping("/reservation/{reservationId}") public List<Payment> byReservation(@PathVariable Long reservationId){return s.byReservation(reservationId);}
 @GetMapping("/{id}/receipt") public Map<String,Object> receipt(@PathVariable Long id){return s.receipt(id);}
}
