package com.smartparking.parking.service;
import com.smartparking.parking.entity.ParkingSpace; import org.springframework.stereotype.Service;
import java.util.*; import java.util.concurrent.atomic.AtomicLong;
@Service public class ParkingSpaceService {
 private final Map<Long,ParkingSpace> data=new LinkedHashMap<>(); private final AtomicLong seq=new AtomicLong();
 public synchronized ParkingSpace create(ParkingSpace p){p.setId(seq.incrementAndGet());data.put(p.getId(),p);return p;}
 public List<ParkingSpace> all(){return new ArrayList<>(data.values());}
 public ParkingSpace get(Long id){ParkingSpace p=data.get(id);if(p==null)throw new NoSuchElementException("Parking space not found: "+id);return p;}
 public List<ParkingSpace> available(){return data.values().stream().filter(p->"AVAILABLE".equals(p.getStatus())).toList();}
 public List<ParkingSpace> city(String city){return data.values().stream().filter(p->p.getCity()!=null&&p.getCity().equalsIgnoreCase(city)).toList();}
 public List<ParkingSpace> zone(String zone){return data.values().stream().filter(p->p.getZone()!=null&&p.getZone().equalsIgnoreCase(zone)).toList();}
 public ParkingSpace update(Long id,ParkingSpace x){ParkingSpace p=get(id);p.setLocation(x.getLocation());p.setCity(x.getCity());p.setZone(x.getZone());p.setPricePerHour(x.getPricePerHour());p.setStatus(x.getStatus());return p;}
 public void delete(Long id){get(id);data.remove(id);}
 public ParkingSpace reserve(Long id){ParkingSpace p=get(id);if(!"AVAILABLE".equals(p.getStatus()))throw new IllegalStateException("Parking space is not available");p.setStatus("RESERVED");return p;}
 public ParkingSpace release(Long id){ParkingSpace p=get(id);p.setStatus("AVAILABLE");return p;}
 public ParkingSpace occupy(Long id){ParkingSpace p=get(id);p.setStatus("OCCUPIED");return p;}
}
