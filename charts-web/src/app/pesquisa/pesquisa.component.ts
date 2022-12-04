import { PesquisaService } from './../service/pesquisa.service';
import { Pesquisa } from './../model/pesquisa';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Chart, registerables } from 'chart.js';

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrls: ['./pesquisa.component.css']
})
export class PesquisaComponent implements OnInit {

  pesquisa = new Pesquisa();
  alertMensagem = '';
  comediaTotal!: number;
  romanceTotal!: number;
  acaoTotal!: number;
  terrorTotal!: number;
  dramaTotal!: number;

  constructor(private pesquisaService: PesquisaService) {
    Chart.register(...registerables);
   }

  @ViewChild("graficoPizza", {static: true}) elemento1!: ElementRef;

  ngOnInit(): void {

    this.pesquisaService.totalComedia().subscribe(dados => {
      this.comediaTotal = dados;

    this.pesquisaService.totalRomance().subscribe(dados => {
      this.romanceTotal = dados;

    this.pesquisaService.totalAcao().subscribe(dados => {
      this.acaoTotal = dados;

    this.pesquisaService.totalTerror().subscribe(dados => {
      this.terrorTotal = dados;

    this.pesquisaService.totalDrama().subscribe(dados => {
      this.dramaTotal = dados;

    new Chart(this.elemento1.nativeElement, {
      type: 'pie',
      data: {
        labels: ["Comédia","Romance","Ação","Terror", "Drama"],
        datasets: [{
          data: [this.comediaTotal, this.romanceTotal, this.acaoTotal, this.terrorTotal, this.dramaTotal]
        }]
      },
      options: {
        responsive: true
      }
    });

  });
  });
  });
  });
  });
};

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
    window.location.reload();
  }

}
