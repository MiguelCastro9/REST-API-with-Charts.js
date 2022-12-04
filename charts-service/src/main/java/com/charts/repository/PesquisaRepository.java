package com.charts.repository;

import com.charts.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {

    @Query(value = "SELECT COUNT(*) FROM pesquisa WHERE preferencia = 'comedia'", nativeQuery = true)
    public Integer queryTotalPreferenciaComedia();

    @Query(value = "SELECT COUNT(*) FROM pesquisa WHERE preferencia = 'romance'", nativeQuery = true)
    public Integer queryTotalPreferenciaRomance();

    @Query(value = "SELECT COUNT(*) FROM pesquisa WHERE preferencia = 'acao'", nativeQuery = true)
    public Integer queryTotalPreferenciaAcao();

    @Query(value = "SELECT COUNT(*) FROM pesquisa WHERE preferencia = 'terror'", nativeQuery = true)
    public Integer queryTotalPreferenciaTerror();

    @Query(value = "SELECT COUNT(*) FROM pesquisa WHERE preferencia = 'drama'", nativeQuery = true)
    public Integer queryTotalPreferenciaDrama();
}
