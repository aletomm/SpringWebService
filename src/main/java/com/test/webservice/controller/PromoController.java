package com.test.webservice.controller;

import com.test.webservice.entities.Promo;
import com.test.webservice.service.PromoService;
import lombok.extern.java.Log;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/promo")
public class PromoController {

    @Autowired
    private PromoService promoService;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PromoController.class);

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Promo>> listAllPromos() {
        log.info("***** Otteniamo tutte le promo *****");

        List<Promo> promo = promoService.selTutti();

        if(promo.isEmpty()) {
            return new ResponseEntity<List<Promo>>(HttpStatus.NO_CONTENT);
        }

        log.info("***** Numero di promo trovate: " + promo.size() + "*****");

        return new ResponseEntity<List<Promo>>(promo, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{idPromo}", produces = "application/json")
    public ResponseEntity<Promo> listPromoById(@PathVariable("idPromo") String idPromo) {
        log.info("****** Otteniamo la promozione con id: " + idPromo + " ******");

        Promo promo = promoService.SelByIdPromo(idPromo);

        if(promo == null) {
            return new ResponseEntity<Promo>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Promo>(promo, HttpStatus.OK);
    }

    @GetMapping(value = "/codice", produces = "application/json")
    public ResponseEntity<Promo> listPromoByCodice(@RequestParam("anno") int anno, @RequestParam("codice") String codice) {
        log.info("****** Otteniamo la promozione con codice: " + codice + " ******");

        Promo promo = promoService.SelByAnnoCodice(anno, codice);

        if(promo == null) {
            return new ResponseEntity<Promo>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Promo>(promo, HttpStatus.OK);
    }

    @GetMapping(value = "/active", produces = "application/json")
    public ResponseEntity<List<Promo>> listPromoActive() {
        log.info("****** Otteniamo le promozioni attive ******");

        List<Promo> promo = promoService.SelActivePromo(new Date());

        if(promo.isEmpty()) {
            return new ResponseEntity<List<Promo>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Promo>>(promo, HttpStatus.OK);
    }

}
