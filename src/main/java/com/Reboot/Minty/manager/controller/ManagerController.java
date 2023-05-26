package com.Reboot.Minty.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
    @GetMapping(value = "manager")
    public String manager() {
        return "manager/dashboard";
    }
}
