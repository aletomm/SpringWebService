package com.test.webservice.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROMO")
@Data
public class Promo implements Serializable {

    private static final long serialVersionUID = -8803588076347536094L;

    @Id
    @Column(name = "IDPROMO")
    private String idPromo;

    @Basic(optional = false)
    @Column(name = "ANNO")
    private int anno;

    @Basic(optional = false)
    @Column(name = "CODICE")
    private String codice;

    @Basic
    @Column(name = "DESCRIZIONE")
    String descrizione;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "promo", orphanRemoval = true)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<DettPromo> dettPromo = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "promo", orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<DepRifPromo> depRifPromo = new HashSet<>();
}
