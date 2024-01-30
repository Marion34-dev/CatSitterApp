package com.petsitter.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class RegistrationController {
    @GetMapping("/register")
    public String catSitterRegistration() {
        return "catSitter";
    }

    @PostMapping("/register")
    public String processRegistration(@RequestParam String fullName,
                                      @RequestParam String email,
                                      @RequestParam String phone,
                                      @RequestParam int experience,
                                      @RequestParam(value = "availability", required = false) List<String> availability,
                                      @RequestParam String additionalInfo,
                                      Model model) {

        model.addAttribute("message", "Registration successful!");
        return "registrationSuccess";
    }
}
