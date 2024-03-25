package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.AuthenticationResponse;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.AuthenticationService;
import net.javaguides.springboot.service.DemandService;
import net.javaguides.springboot.service.MeritOrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authService;
    private MeritOrderService meritOrderService;
    private DemandService demandService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
            ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}