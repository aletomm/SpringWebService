package com.test.webservice.repositories;

import com.test.webservice.entities.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {

    Promo findByIdPromo(String idPromo);

    Promo findByAnnoAndCodice(int anno, String codice);

    // Metodo alternativo
    @Query(value = "SELECT a FROM Promo a JOIN a.dettPromo b WHERE :data BETWEEN b.inizio and b.fine")
    List<Promo> SelActivePromo(@Param("data") Date data);
}
