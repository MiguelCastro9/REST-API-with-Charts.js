package com.charts.controller;

import com.charts.model.Pesquisa;
import com.charts.service.PesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/pesquisa")
public class PesquisaController {

    @Autowired
    PesquisaService pesquisaService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Pesquisa pesquisa) {

        try {
            if (pesquisa == null) {

                return new ResponseEntity<>("A pesquisa não foi preenchida.", HttpStatus.CONFLICT);
            }

            pesquisaService.registrar(pesquisa);

        } catch (Exception e) {

            return new ResponseEntity<>("Ocorreu um erro ao registrar a pesquisa.", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("Pesquisa registrada com sucesso!", HttpStatus.OK);
    }
}
