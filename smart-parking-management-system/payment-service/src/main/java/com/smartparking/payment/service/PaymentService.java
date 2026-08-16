package com.smartparking.payment.service;
import com.smartparking.payment.entity.Payment; import org.springframework.stereotype.Service;
import java.util.*; import java.util.concurrent.atomic.AtomicLong;
@Service public class PaymentService {
 private final Map<Long,Payment> data=new LinkedHashMap<>(); private final AtomicLong seq=new AtomicLong();
 public synchronized Payment pay(Payment p){p.setId(seq.incrementAndGet());p.setTransactionId("TXN-"+UUID.randomUUID().toString().substring(0,8).toUpperCase()); if(p.getAmount()<=0) throw new IllegalArgumentException("Amount must be greater than zero"); p.setStatus("SUCCESS");data.put(p.getId(),p);return p;}
 public Payment get(Long id){Payment p=data.get(id);if(p==null)throw new NoSuchElementException("Payment not found: "+id);return p;}
 public List<Payment> all(){return new ArrayList<>(data.values());}
 public List<Payment> byUser(Long userId){return data.values().stream().filter(p->Objects.equals(p.getUserId(),userId)).toList();}
 public List<Payment> byReservation(Long reservationId){return data.values().stream().filter(p->Objects.equals(p.getReservationId(),reservationId)).toList();}
 public Map<String,Object> receipt(Long id){Payment p=get(id);Map<String,Object> r=new LinkedHashMap<>();r.put("receiptNumber","REC-"+p.getId());r.put("transactionId",p.getTransactionId());r.put("reservationId",p.getReservationId());r.put("userId",p.getUserId());r.put("amount",p.getAmount());r.put("paymentMethod",p.getPaymentMethod());r.put("status",p.getStatus());return r;}
}
