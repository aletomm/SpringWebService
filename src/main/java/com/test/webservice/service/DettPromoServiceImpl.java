package com.test.webservice.service;

import com.test.webservice.entities.DettPromo;
import com.test.webservice.repositories.DettPromoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DettPromoServiceImpl implements DettPromoService {

    @Autowired
    private DettPromoRepository dettPromoRepository;

    @Override
    public DettPromo SelDettPromoByCodFid(String codFid, String codArt) {
        return dettPromoRepository.SelDettPromoByCodFid(codFid, codArt);
    }
}
