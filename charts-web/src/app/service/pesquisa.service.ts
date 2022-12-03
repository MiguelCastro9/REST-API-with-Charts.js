import { Pesquisa } from './../model/pesquisa';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PesquisaService {

  url = "http://localhost:8080/pesquisa";

constructor(private http: HttpClient) { }

  registrar(pesquisa: Pesquisa){
    return this.http.post<Pesquisa>(this.url + '/registrar', pesquisa);
  }

  totalComedia(){
    return this.http.get<number>(this.url + '/comedia');
  }

  totalRomance(){
    return this.http.get<number>(this.url + '/romance');
  }

  totalAcao(){
    return this.http.get<number>(this.url + '/acao');
  }

  totalTerror(){
    return this.http.get<number>(this.url + '/terror');
  }

  totalDrama(){
    return this.http.get<number>(this.url + '/drama');
  }

}
