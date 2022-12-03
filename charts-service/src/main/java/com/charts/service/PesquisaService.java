package com.charts.service;

import com.charts.model.Pesquisa;
import com.charts.repository.PesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PesquisaService {

    @Autowired
    private PesquisaRepository pesquisaRepository;

    public void registrar(Pesquisa pesquisa) {

        pesquisaRepository.save(pesquisa);
    }

    public Integer totalPreferenciaComedia() {

        return pesquisaRepository.queryTotalPreferenciaComedia();
    }

    public Integer totalPreferenciaRomance() {

        return pesquisaRepository.queryTotalPreferenciaRomance();
    }

    public Integer totalPreferenciaAcao() {

        return pesquisaRepository.queryTotalPreferenciaAcao();
    }

    public Integer totalPreferenciaTerror() {

        return pesquisaRepository.queryTotalPreferenciaTerror();
    }

    public Integer totalPreferenciaDrama() {

        return pesquisaRepository.queryTotalPreferenciaDrama();
    }
}
