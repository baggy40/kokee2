package com.example.commerce.controller;

import com.example.commerce.dto.admin.AdminDto;
import com.example.commerce.entity.admin.AdminEntity;
import com.example.commerce.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {

    private final AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String main(){
        return "main";
    }

   @GetMapping(value = "/new")
    public String adminForm(Model model){
       model.addAttribute("adminDto", new AdminDto());
       return "admin/adminForm";
   }

   @PostMapping(value = "/new")
    public String adminForm(@Valid AdminDto adminDto,
                            BindingResult bindingResult, Model model){

       if(bindingResult.hasErrors()){
           return "admin/adminForm";
       }

       try {
           AdminEntity admin = AdminEntity.createAdmin(adminDto, passwordEncoder);
           adminRepository.save(admin);
       }catch (IllegalStateException e){
          // model.addAttribute("errorMessage", e.getMessage());
           return "admin/adminForm";
       }

       return "redirect:/admins/login";
   }

   @GetMapping(value = "/login")
    public String adminLogin(){
        return "login/login";
   }


    @GetMapping(value = "/receive")
    public String wareReceive(){
        return "warehouse/receive";
    }

}
