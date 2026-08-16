package com.smartparking.vehicle.service;
import com.smartparking.vehicle.entity.Vehicle;
import org.springframework.stereotype.Service;
import java.util.*; import java.util.concurrent.atomic.AtomicLong;
@Service
public class VehicleService {
 private final Map<Long,Vehicle> data=new LinkedHashMap<>(); private final AtomicLong seq=new AtomicLong();
 public synchronized Vehicle create(Vehicle v){v.setId(seq.incrementAndGet());data.put(v.getId(),v);return v;}
 public List<Vehicle> all(){return new ArrayList<>(data.values());}
 public Vehicle get(Long id){Vehicle v=data.get(id);if(v==null)throw new NoSuchElementException("Vehicle not found: "+id);return v;}
 public List<Vehicle> byUser(Long userId){return data.values().stream().filter(v->Objects.equals(v.getUserId(),userId)).toList();}
 public Vehicle update(Long id,Vehicle x){Vehicle v=get(id);v.setVehicleNumber(x.getVehicleNumber());v.setVehicleType(x.getVehicleType());v.setBrand(x.getBrand());v.setModel(x.getModel());v.setColor(x.getColor());return v;}
 public void delete(Long id){get(id);data.remove(id);}
 public Vehicle entry(Long id){Vehicle v=get(id);v.setStatus("INSIDE");return v;}
 public Vehicle exit(Long id){Vehicle v=get(id);v.setStatus("PARKED_OUTSIDE");return v;}
}
