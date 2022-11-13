package com.example.commerce.service.admin;

import com.example.commerce.entity.admin.AdminEntity;
import com.example.commerce.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity admin =  adminRepository.findByName(username);
        System.out.println("admin====================="+admin);

        if(admin == null){
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(admin.getName())
                .password(admin.getPassword())
                .build();
    }
}
