package com.amelinroman.spring.security.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "view-for-all-employees";
    }

    @GetMapping("/hr_info")
    public String getHRInfo() {
        return "view-for-hr";
    }

    @GetMapping("/manager_info")
    public String getManagerInfo() {
        return "view-for-manager";
    }
}
