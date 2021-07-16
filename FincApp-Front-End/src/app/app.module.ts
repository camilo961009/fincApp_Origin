import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent} from './footer/footer.component';
import { DirectivaComponent } from './directiva/directiva.component';
import { RouterModule, Routes} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination'

import { TrabajadoresComponent } from './trabajadores/trabajadores.component';
import { FormComponent } from './trabajadores/form.component';
import { TrabajadorService } from './trabajadores/trabajador.service';

import { CultivosComponent } from './cultivos/cultivos.component'; 
import {Formulario1Component} from './cultivos/formulario1.component';
import { CultivoService } from './cultivos/cultivo.service';

import { CosechasComponent } from './cosechas/cosechas.component';
import { Formulario2Component } from './cosechas/formulario2.component';
import { CosechaService } from './cosechas/cosecha.service';

import { InsumosComponent } from './insumos/insumos.component';
import { Formulario3Component } from './insumos/formulario3.component';
import { InsumoService } from './insumos/insumo.service';


import { ControlesComponent } from './controles/controles.component';
import { Formulario4Component } from './controles/formulario4.component';
import { ControlService } from './controles/control.service';

import { AuxiliaresComponent } from './auxiliares/auxiliares.component';
import { Formulario5Component } from './auxiliares/formulario5.component';
import { AuxiliarService } from './auxiliares/auxiliar.service';

import { EmailformComponent } from './trabajadores/emailform.component';



const routes: Routes = [
  {path: '', redirectTo: '/trabajadores', pathMatch: 'full'},
  {path: 'directivas', component: DirectivaComponent},

  {path: 'trabajadores', component: TrabajadoresComponent},
  {path: 'trabajadores/form', component: FormComponent},
  {path: 'trabajadores/form/:cedula', component: FormComponent},

  {path: 'cultivos', component: CultivosComponent},
  {path: 'cultivos/formulario1', component: Formulario1Component},
  {path: 'cultivos/formulario1/:idcultivo', component: Formulario1Component},

  {path: 'cosechas', component: CosechasComponent},
  {path: 'cosechas/formulario2', component: Formulario2Component},
  {path: 'cosechas/formulario2/:idcosecha', component: Formulario2Component},
  
  {path: 'insumos', component: InsumosComponent},
  {path: 'insumos/formulario3', component: Formulario3Component},
  {path: 'insumos/formulario3/:idinsumo', component: Formulario3Component},

  {path: 'controles', component: ControlesComponent},
  {path: 'controles/formulario4', component: Formulario4Component},
  {path: 'controles/formulario4/:idcontrol', component: Formulario4Component},

  {path: 'auxiliares', component: AuxiliaresComponent},
  {path: 'auxiliares/formulario5', component: Formulario5Component},
  {path: 'auxiliares/formulario5/:cedula', component: Formulario5Component},

  {path: 'trabajadores/emailform', component: EmailformComponent}




  
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,

    TrabajadoresComponent,
    FormComponent,

    CultivosComponent,
    Formulario1Component,

    CosechasComponent,
    Formulario2Component,

    InsumosComponent,
    Formulario3Component,
    
    ControlesComponent,
    Formulario4Component,

    AuxiliaresComponent,
    Formulario5Component,
    
    EmailformComponent,
    


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    NgxPaginationModule
  ],
   providers: [TrabajadorService, CultivoService, CosechaService, InsumoService, ControlService, AuxiliarService],
   
  bootstrap: [AppComponent]
})
export class AppModule { }
