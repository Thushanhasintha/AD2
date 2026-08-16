package com.smartparking.vehicle.controller;
import com.smartparking.vehicle.entity.Vehicle; import com.smartparking.vehicle.service.VehicleService;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/vehicles")
public class VehicleController {
 private final VehicleService s; public VehicleController(VehicleService s){this.s=s;}
 @PostMapping public ResponseEntity<Vehicle> create(@RequestBody Vehicle v){return ResponseEntity.status(HttpStatus.CREATED).body(s.create(v));}
 @GetMapping public List<Vehicle> all(){return s.all();}
 @GetMapping("/{id}") public Vehicle get(@PathVariable Long id){return s.get(id);}
 @GetMapping("/user/{userId}") public List<Vehicle> byUser(@PathVariable Long userId){return s.byUser(userId);}
 @PutMapping("/{id}") public Vehicle update(@PathVariable Long id,@RequestBody Vehicle v){return s.update(id,v);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){s.delete(id);return ResponseEntity.noContent().build();}
 @PostMapping("/{id}/entry") public Vehicle entry(@PathVariable Long id){return s.entry(id);}
 @PostMapping("/{id}/exit") public Vehicle exit(@PathVariable Long id){return s.exit(id);}
}
