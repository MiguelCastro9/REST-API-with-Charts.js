package com.charts.controller;

import com.charts.model.Pesquisa;
import com.charts.service.PesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = "*")
public class PesquisaController {

    @Autowired
    PesquisaService pesquisaService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Pesquisa pesquisa) {

        try {

            pesquisaService.registrar(pesquisa);

        } catch (Exception e) {

            if (pesquisa == null) {

                return new ResponseEntity<>("A pesquisa não foi preenchida.", HttpStatus.CONFLICT);
            }

            return new ResponseEntity<>("Ocorreu um erro ao registrar a pesquisa.", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("Pesquisa registrada com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/comedia")
    public ResponseEntity<Integer> totalPreferenciaComedia() {

        try {

            pesquisaService.totalPreferenciaComedia();

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(pesquisaService.totalPreferenciaComedia(), HttpStatus.OK);
    }

    @GetMapping("/romance")
    public ResponseEntity<Integer> totalPreferenciaRomance() {

        try {

            pesquisaService.totalPreferenciaRomance();

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(pesquisaService.totalPreferenciaRomance(), HttpStatus.OK);
    }

    @GetMapping("/acao")
    public ResponseEntity<Integer> totalPreferenciaAcao() {

        try {

            pesquisaService.totalPreferenciaAcao();

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(pesquisaService.totalPreferenciaAcao(), HttpStatus.OK);
    }

    @GetMapping("/terror")
    public ResponseEntity<?> totalPreferenciaTerror() {

        try {

            pesquisaService.totalPreferenciaTerror();

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(pesquisaService.totalPreferenciaTerror(), HttpStatus.OK);
    }

    @GetMapping("/drama")
    public ResponseEntity<?> totalPreferenciaDrama() {

        try {

            pesquisaService.totalPreferenciaDrama();

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(pesquisaService.totalPreferenciaDrama(), HttpStatus.OK);
    }
}
