package com.test.webservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TIPOPROMO")
@Data
public class TipoPromo implements Serializable {

    private static final long serialVersionUID = -6913860615270264729L;

    @Id
    @Column(name = "IDTIPOPROMO")
    private String idTipoPromo;

    @Basic
    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoPromo")
    @JsonBackReference
    private Set<DettPromo> dettPromo = new HashSet<>();
}
