package com.example.commerce.admin;

import com.example.commerce.dto.admin.AdminDto;
import com.example.commerce.entity.admin.AdminEntity;
import com.example.commerce.repository.admin.AdminRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AdminTest {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AdminEntity createAdmin(){
        AdminDto adminDto = new AdminDto();
        adminDto.setName("박현진");
        adminDto.setPassword("park0315");
        return AdminEntity.createAdmin(adminDto, passwordEncoder);
    }

    @Test
    @DisplayName("admin 테스트")
    public void saveAdmin(){
        AdminEntity adminEntity = createAdmin();
        AdminEntity savedAdmin = adminRepository.save(adminEntity);

        assertEquals(adminEntity.getName(), savedAdmin.getName());
        assertEquals(adminEntity.getPassword(), savedAdmin.getPassword());
    }

}
