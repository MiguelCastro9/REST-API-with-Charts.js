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
}
