package com.michael.ThesisHubBackend;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('Admin')")
    public String hello() {
        return "Hello from Admin";
    }

    @GetMapping("/lecturer")
    @PreAuthorize("hasRole('Lecturer')")
    public String hello2() {
        return "Hello from Lecturer";
    }
}
