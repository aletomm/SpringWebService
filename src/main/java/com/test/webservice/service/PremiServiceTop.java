package com.test.webservice.service;

import org.springframework.stereotype.Service;

@Service("TOP")
public class PremiServiceTop implements PremiService{
    @Override
    public double getPremio() {
        return 1000;
    }
}
