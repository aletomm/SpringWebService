package com.test.webservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DETTPROMO")
@Data
public class DettPromo {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    @Column(name = "RIGA")
    private int riga;

    @Basic(optional = false)
    @Column(name = "CODART")
    private String codArt;

    @Basic
    @Column(name = "CODFID")
    private String codFid;

    @Column(name = "INIZIO")
    @Temporal(TemporalType.DATE)
    private Date inizio;

    @Column(name = "FINE")
    @Temporal(TemporalType.DATE)
    private Date fine;

    @Basic(optional = false)
    @Column(name = "OGGETTO")
    private String oggetto;

    @Basic
    @Column(name = "ISFID")
    private String isFid;

    @ManyToOne
    @JoinColumn(name = "IDPROMO", referencedColumnName = "idPromo")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Promo promo;

    @ManyToOne
    @JoinColumn(name="IDTIPOPROMO", referencedColumnName = "idTipoPromo")
    @EqualsAndHashCode.Exclude
    private TipoPromo tipoPromo;

}
