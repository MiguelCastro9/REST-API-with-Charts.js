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

  constructor(private pesquisaService: PesquisaService) { }

  ngOnInit(): void {
  }

  registrar(pesquisa: Pesquisa) {

    this.pesquisaService.registrar(pesquisa).subscribe(dados => {
      console.log(dados);

    });
  }

}
