import { PesquisaService } from './../service/pesquisa.service';
import { Pesquisa } from './../model/pesquisa';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrls: ['./pesquisa.component.css']
})
export class PesquisaComponent implements OnInit {

  pesquisa = new Pesquisa();
  successMensagem = false;
  alertMensagem = '';

  constructor(private pesquisaService: PesquisaService) { }

  ngOnInit(): void {
  }

  validarFormulario() {

    if (!this.pesquisa.voluntario) {
      this.alertMensagem = 'Campo voluntário é obrigatório.';
      return false;
    }
    if (!this.pesquisa.preferencia) {
      this.alertMensagem = 'Campo preferência é obrigatório.';
      return false;
    }
    return true;
  }

  registrar(pesquisa: Pesquisa) {

    if (!this.validarFormulario()) {
      return;
    }

    this.pesquisaService.registrar(pesquisa).subscribe();
    this.pesquisa = new Pesquisa();
    this.successMensagem = true;
  }

}
