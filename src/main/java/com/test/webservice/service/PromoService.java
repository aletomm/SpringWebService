package com.test.webservice.service;

import com.test.webservice.entities.Promo;

import java.util.Date;
import java.util.List;

public interface PromoService {

    public List<Promo> selTutti();

    public Promo SelByIdPromo(String idPromo);

    public Promo SelByAnnoCodice(int anno, String codice);

    public List<Promo> SelActivePromo(Date data);
}
