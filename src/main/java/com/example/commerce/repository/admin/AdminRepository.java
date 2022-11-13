package com.example.commerce.repository.admin;

import com.example.commerce.entity.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    AdminEntity findByName(String username);
}
