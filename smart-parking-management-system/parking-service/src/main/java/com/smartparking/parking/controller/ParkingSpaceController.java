package com.smartparking.parking.controller;
import com.smartparking.parking.entity.ParkingSpace; import com.smartparking.parking.service.ParkingSpaceService;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/parking/spaces")
public class ParkingSpaceController {
 private final ParkingSpaceService s; public ParkingSpaceController(ParkingSpaceService s){this.s=s;}
 @PostMapping public ResponseEntity<ParkingSpace> create(@RequestBody ParkingSpace p){return ResponseEntity.status(HttpStatus.CREATED).body(s.create(p));}
 @GetMapping public List<ParkingSpace> all(){return s.all();}
 @GetMapping("/available") public List<ParkingSpace> available(){return s.available();}
 @GetMapping("/city/{city}") public List<ParkingSpace> city(@PathVariable String city){return s.city(city);}
 @GetMapping("/zone/{zone}") public List<ParkingSpace> zone(@PathVariable String zone){return s.zone(zone);}
 @GetMapping("/{id}") public ParkingSpace get(@PathVariable Long id){return s.get(id);}
 @PutMapping("/{id}") public ParkingSpace update(@PathVariable Long id,@RequestBody ParkingSpace p){return s.update(id,p);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){s.delete(id);return ResponseEntity.noContent().build();}
 @PostMapping("/{id}/reserve") public ParkingSpace reserve(@PathVariable Long id){return s.reserve(id);}
 @PostMapping("/{id}/release") public ParkingSpace release(@PathVariable Long id){return s.release(id);}
 @PostMapping("/{id}/occupy") public ParkingSpace occupy(@PathVariable Long id){return s.occupy(id);}
}
