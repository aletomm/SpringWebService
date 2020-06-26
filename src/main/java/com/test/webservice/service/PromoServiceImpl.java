package com.test.webservice.service;

import com.test.webservice.entities.Promo;
import com.test.webservice.repositories.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoRepository promoRepository;

    @Override
    public List<Promo> selTutti() {
        return promoRepository.findAll();
    }

    @Override
    public Promo SelByIdPromo(String idPromo) {
        return promoRepository.findByIdPromo(idPromo);
    }

    @Override
    public Promo SelByAnnoCodice(int anno, String codice) {
        return promoRepository.findByAnnoAndCodice(anno, codice);
    }

    @Override
    public List<Promo> SelActivePromo(Date data) {
        return promoRepository.SelActivePromo(data);
    }
}
