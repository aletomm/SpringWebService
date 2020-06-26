package com.test.webservice.controller;

import com.test.webservice.entities.Articoli;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/articoli")
@Log
public class ArticoliController {

    private List<Articoli> initData() {
        List<Articoli> articoli = new ArrayList<>();

        articoli.add(new Articoli("014600301", "BARILLA FARINA 1 KG", "PZ", 24, 1.0,1.09));
        articoli.add(new Articoli("014611301", "BARILLA PASTA GR.500 KG", "PZ", 30, 0.500,1.30));
        articoli.add(new Articoli("011600301", "FINDUS FIOR DI NASELLO 300 GR", "PZ", 8, 0.300,6.09));

        return articoli;
    }

    @GetMapping(value = "/cerca/codice/{codart}", produces = "application/json")
    public ResponseEntity<Articoli> listArtByCodArt(@PathVariable("codart") String codArt) {
        log.info("********* Otteniamo l'articolo con codice " + codArt + " **********");

        List<Articoli> articolo = this.initData()
                .stream()
                .filter(u -> u.getCodArt().equals(codArt))
                .collect(Collectors.toList());
        if (articolo.size() > 0) {
            return new ResponseEntity<Articoli>(articolo.get(0), HttpStatus.OK);

        }else {
            return new ResponseEntity<Articoli>(new Articoli(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/cerca/descrizione/{filter}", produces = "application/json")
    public ResponseEntity<List<Articoli>> listArtByDesc(@PathVariable("filter") String filter) {

        log.info("********* Otteniamo gli articoli con descrizione " + filter + " **********");

        List<Articoli> articoli = this.initData()
                .stream()
                .filter(u -> u.getDescrizione().toUpperCase().contains(filter.toUpperCase()))
                .collect(Collectors.toList());

        if (articoli.size() > 0) {
            return new ResponseEntity<List<Articoli>>(articoli, HttpStatus.OK);
        } else {
            articoli.add(new Articoli());
            return new ResponseEntity<List<Articoli>>(articoli, HttpStatus.NOT_FOUND);
        }
    }

}
