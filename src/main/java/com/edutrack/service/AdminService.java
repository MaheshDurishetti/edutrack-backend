package com.edutrack.service;

import com.edutrack.model.Admin;
import com.edutrack.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin loginAdmin(String email, String password) {
        return adminRepository.findByEmail(email)
                .filter(a -> a.getPassword().equals(password))
                .orElse(null);
    }
}
