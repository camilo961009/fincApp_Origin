import { Component, OnInit } from '@angular/core';
import {Auxiliar} from './auxiliar'
import {AuxiliarService} from './auxiliar.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'


@Component({
  selector: 'app-formulario5',
  templateUrl: './formulario5.component.html'
})
export class Formulario5Component implements OnInit {

  private auxiliar: Auxiliar=new Auxiliar()
  private titulo:string = "Crear Auxiliar"

  constructor(private auxiliarService: AuxiliarService,
    private router: Router,
  private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarAuxiliar()
  }

  cargarAuxiliar(): void{
    this.activatedRoute.params.subscribe(params => {
      let cedula = params['cedula']
      if(cedula){
        this.auxiliarService.getAuxiliar(cedula).subscribe( (auxiliar) => this.auxiliar = auxiliar)
      }
    })
  }



  create(): void {
    console.log(this.auxiliar)
    this.auxiliarService.create(this.auxiliar)
      .subscribe(auxiliar => {
        this.router.navigate(['/auxiliares'])
        swal('Nuevo auxiliar', `Auxiliar ${auxiliar.nombre} creado con éxito!`, 'success')
      }
      );
  }

  update():void{
    this.auxiliarService.update(this.auxiliar)
    .subscribe( auxiliar => {
      this.router.navigate(['/auxiliares'])
      swal('Auxiliar Actualizado', `Auxiliar ${auxiliar.nombre} actualizado con éxito!`, 'success')
    }

    )
  }


}
