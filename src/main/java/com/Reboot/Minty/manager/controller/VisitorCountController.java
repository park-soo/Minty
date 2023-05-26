package com.Reboot.Minty.manager.controller;

import com.Reboot.Minty.manager.dto.VisitorCountDto;
import com.Reboot.Minty.manager.service.VisitorCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VisitorCountController {

    private final VisitorCountService visitorCountService;

    @Autowired
    public VisitorCountController(VisitorCountService visitorCountService) {
        this.visitorCountService = visitorCountService;
    }

    @GetMapping("/getVisitorCounts")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getVisitorCounts() {
        List<VisitorCountDto> visitorCounts = visitorCountService.getAllVisitorCounts();

        Map<String, Object> response = new HashMap<>();
        response.put("data", visitorCounts);

        return ResponseEntity.ok(response);
    }
}
