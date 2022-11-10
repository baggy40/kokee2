package com.example.commerce.entity.admin;

import com.example.commerce.dto.admin.AdminDto;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Data
public class AdminEntity {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    public static AdminEntity createAdmin(AdminDto adminDto, PasswordEncoder passwordEncoder){
        AdminEntity admin = new AdminEntity();
        admin.setName(adminDto.getName());
        String password = passwordEncoder.encode(adminDto.getPassword());
        admin.setPassword(password);
        return admin;
    }
}
