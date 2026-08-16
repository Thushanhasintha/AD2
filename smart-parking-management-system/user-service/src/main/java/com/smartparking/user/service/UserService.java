package com.smartparking.user.service;

import com.smartparking.user.entity.User;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> users = new LinkedHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public synchronized User create(User user) {
        user.setId(sequence.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }
    public List<User> findAll() { return new ArrayList<>(users.values()); }
    public User findById(Long id) {
        User u = users.get(id);
        if (u == null) throw new NoSuchElementException("User not found: " + id);
        return u;
    }
    public User update(Long id, User data) {
        User u = findById(id);
        u.setName(data.getName()); u.setEmail(data.getEmail()); u.setPhone(data.getPhone()); u.setRole(data.getRole());
        if (data.getPassword() != null && !data.getPassword().isBlank()) u.setPassword(data.getPassword());
        return u;
    }
    public void delete(Long id) { findById(id); users.remove(id); }
    public User login(String email, String password) {
        return users.values().stream()
            .filter(u -> u.getEmail().equalsIgnoreCase(email) && Objects.equals(u.getPassword(), password))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    }
}
