package com.charts.repository;

import com.charts.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
    
}
