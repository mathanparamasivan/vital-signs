package com.app.vitalsign.controller;

import com.app.vitalsign.dto.VitalSignDTO;
import com.app.vitalsign.entity.VitalSign;
import com.app.vitalsign.service.VitalSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vital-signs")
public class VitalSignController {

    @Autowired
    private VitalSignService service;

    @PostMapping
    public VitalSignDTO recordVitalSign(@RequestBody VitalSignDTO vitalSign) {
        return service.saveVitalSign(vitalSign);
    }

    @GetMapping
    public List<VitalSignDTO> getVitalSigns() {
        return service.getAllVitalSigns();
    }

//    @GetMapping
//    public String getVitalSign(){
//        return "Vital Sign Working";
//    }
}
