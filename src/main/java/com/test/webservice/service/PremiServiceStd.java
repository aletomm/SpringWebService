package com.test.webservice.service;

import org.springframework.stereotype.Service;

@Service("STD")
public class PremiServiceStd implements PremiService{
    @Override
    public double getPremio() {
        return 100;
    }
}
