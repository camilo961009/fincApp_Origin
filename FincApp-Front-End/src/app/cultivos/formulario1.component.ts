import { Component, OnInit } from '@angular/core';
import {Cultivo} from './cultivo'
import {CultivoService} from './cultivo.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'

@Component({
  selector: 'app-formulario1',
  templateUrl: './formulario1.component.html'
})


export class Formulario1Component implements OnInit {

  private cultivo: Cultivo = new Cultivo()
  private titulo:string = "Crear Cultivo"

  constructor(private cultivoService: CultivoService,
    private router: Router,
  private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarCultivo()
  }

  cargarCultivo(): void{
    this.activatedRoute.params.subscribe(params => {
      let idcultivo = params['idcultivo']
      if(idcultivo){
        this.cultivoService.getCultivo(idcultivo).subscribe( (cultivo) => this.cultivo = cultivo)
      }
    })
  }


  create(): void {
   
    this.cultivoService.create(this.cultivo)
      .subscribe(cultivo => {
        this.router.navigate(['/cultivos'])
        swal('Nuevo Cultivo', `Cultivo de ${cultivo.tipoCultivo} creado con éxito!`, 'success')
      }
      );
  }

  update():void{
    this.cultivoService.update(this.cultivo)
    .subscribe( cultivo => {
      this.router.navigate(['/cultivos'])
      swal('Cultivo Actualizado', `Cultivo de ${cultivo.tipoCultivo} actualizado con éxito!`, 'success')
    }

    )
  }



}
