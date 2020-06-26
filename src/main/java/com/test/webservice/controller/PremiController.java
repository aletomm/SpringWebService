package com.test.webservice.controller;

import com.test.webservice.service.PremiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/premio")
public class PremiController {

    @Autowired
    @Qualifier("STD")
    PremiService premioServiceSTD;

    @Autowired
    @Qualifier("TOP")
    PremiService premioServiceTOP;

    @GetMapping(value = "/cerca/codice/{idfidelity}", produces = "application/json")
    public ResponseEntity<Double> getPremio(@PathVariable("idfidelity") String idFidelity) {

        Double premio = 0.00;

        if (idFidelity.equals("1")) {
            premio = premioServiceSTD.getPremio();
        } else {
            premio = premioServiceTOP.getPremio();
        }

        return new ResponseEntity<Double>(premio, HttpStatus.OK);
    }
}
