import { Component, OnInit } from '@angular/core';
import {Insumo} from './insumo'
import {InsumoService} from './insumo.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'

@Component({
  selector: 'app-formulario3',
  templateUrl: './formulario3.component.html'
})
export class Formulario3Component implements OnInit {

  private insumo:Insumo=new Insumo();
  private titulo:string = "Crear Insumo";

  constructor(private insumoService:InsumoService,
    private router:Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarInsumo();
  }

  cargarInsumo(): void{
    this.activatedRoute.params.subscribe(params => {
      let idinsumo = params['idinsumo']
      if(idinsumo){
        this.insumoService.getInsumo(idinsumo).subscribe( (insumo) => this.insumo = insumo)
      }
    })
  }

  
  create(): void {
  
    this.insumoService.create(this.insumo)
      .subscribe(insumo => {
        this.router.navigate(['/insumos'])
        swal('Nuevo Insumo', `Insumo ${insumo.nombre} creado con éxito!`, 'success')
      }
      );
  }

  update():void{
    this.insumoService.update(this.insumo)
    .subscribe( insumo => {
      this.router.navigate(['/insumos'])
      swal('Insumo Actualizado', `Insumo ${insumo.nombre} actualizado con éxito!`, 'success')
    }

    )
  }

}
