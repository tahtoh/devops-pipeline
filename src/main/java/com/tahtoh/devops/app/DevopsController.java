package com.tahtoh.devops.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevopsController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
