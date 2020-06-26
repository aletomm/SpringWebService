package com.test.webservice.repositories;

import com.test.webservice.entities.DettPromo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DettPromoRepository extends JpaRepository<DettPromo, Long> {

    @Query(value = "EXEC Sp_SelActivePromoFid :codFid,:codArt", nativeQuery = true)
    DettPromo SelDettPromoByCodFid(@Param("codFid") String codFid, @Param("codArt") String codArt);
}
