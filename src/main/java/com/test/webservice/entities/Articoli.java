package com.test.webservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Articoli implements Serializable {

    private static final long serialVersionUID = -6277432999605889942L;
    private String codArt;
    private String descrizione;
    private String um;
    private String codStat;

    private int pzCart;
    private double pesoNetto;
    private String idStatoArt;
    private Date dataCreaz;
    private double prezzo;

    public Articoli() {
    }


    public Articoli(String codArt, String descrizione, String um, int pzCart, double pesoNetto, double prezzo) {
        this.codArt = codArt;
        this.descrizione = descrizione;
        this.um = um;
        this.pzCart = pzCart;
        this.pesoNetto = pesoNetto;
        this.prezzo = prezzo;
    }
}