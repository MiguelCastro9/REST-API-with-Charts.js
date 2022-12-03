import { PesquisaComponent } from './pesquisa/pesquisa.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/pesquisa', pathMatch: 'full' },
  {path: 'pesquisa',  component: PesquisaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
