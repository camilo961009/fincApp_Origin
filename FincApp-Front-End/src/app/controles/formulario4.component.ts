import { Component, OnInit } from '@angular/core';
import {Control} from './control'
import {ControlService} from './control.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'


@Component({
  selector: 'app-formulario4',
  templateUrl: './formulario4.component.html'
})
export class Formulario4Component implements OnInit {
  lista:string[]=["Pimenton","Abichuela","Ahuyama", "Pepino", "Lulo"];

  private control:Control=new Control()
  private titulo:string = "Crear Control"
  seleccionado:string= "";
  value:number= 0;

  constructor(private controlService:ControlService,
    private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.cargarControl();
  }

  capturar(){
    this.value=this.control.cultivo;
  if(this.value=8){
    this.control.cultivo=8;
  }else if(this.value=9){
    this.control.cultivo=9;
  }else if(this.value=10){
    this.control.cultivo=10;
  }else if(this.value=11){
    this.control.cultivo=11;
  }else if(this.value=12){
    this.control.cultivo=12;
  }
  }


  cargarControl(): void{
    this.activatedRoute.params.subscribe(params => {
      let idcontrol = params['idcontrol']
      if(idcontrol){
        this.controlService.getControl(idcontrol).subscribe( (control) => this.control = control)
      }
    })
  }

  create(): void {
   
    this.controlService.create(this.control)
      .subscribe(control => {
        this.router.navigate(['/controles'])
        swal('Nueva control', `Control ${control.nombre} con éxito!`, 'success')
      }
      );
  }

  
  update():void{
    this.controlService.update(this.control)
    .subscribe( control => {
      this.router.navigate(['/controles'])
      swal('Control Actualizado', `Control ${control.nombre} actualizado con éxito!`, 'success')
    }

    )
  }

}
