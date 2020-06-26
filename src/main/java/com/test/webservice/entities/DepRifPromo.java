package com.test.webservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEPRIFPROMO")
@Data
public class DepRifPromo implements Serializable {

    private static final long serialVersionUID = 5416784661668620352L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IDDEPOSITO")
    private int idDeposito;

    @ManyToOne
    @JoinColumn(name = "IDPROMO", referencedColumnName = "idPromo")
    @JsonBackReference
    private Promo promo;
}
