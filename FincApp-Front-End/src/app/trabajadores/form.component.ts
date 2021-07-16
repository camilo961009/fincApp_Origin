import { Component, OnInit } from '@angular/core';
import {Trabajador} from './trabajador'
import {TrabajadorService} from './trabajador.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'
import { Cultivo } from '../cultivos/cultivo';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  lista:string[]=["Pimenton","Abichuela","Ahuyama", "Pepino", "Lulo"];
  cargo:string[]=["Administrador","Empleado"];

  private trabajador: Trabajador = new Trabajador()
  private cultivo: Cultivo = new Cultivo();
  private titulo:string = "Crear Empleado"

  seleccionado:number= 0;
  value:number= 0;
 
  constructor(private trabajadorService: TrabajadorService,
    private router: Router,
   private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarTrabajador()
  }

  

  capturar() {
    
    this.value=this.trabajador.cultivo;
    console.log("El value dio " + this.trabajador.nombreCultivo)
    console.log("Esto es lo que jue1111111 " + this.trabajador.cultivo)
  if(this.trabajador.cultivo==8){
    console.log("Esto es lo que jue2222222 " + this.trabajador.cultivo)
    this.trabajador.cultivo=8;
  }
 //// else if(this.value=9){
 //   this.trabajador.cultivo=9;
 // }else if(this.value=10){
 //   this.trabajador.cultivo=10;
 // }else if(this.value=11){
 //   this.trabajador.cultivo=11;
 // }else if(this.value=12){
  //  this.trabajador.cultivo=12;
 // }

  }




  cargarTrabajador(): void{
    this.activatedRoute.params.subscribe(params => {
      let cedula = params['cedula']
      if(cedula){
        this.trabajadorService.getTrabajador(cedula).subscribe( (trabajador) => this.trabajador = trabajador)
      }
    })
  }

  
  create(): void {
    console.log("Nombre Cultivo "+this.trabajador.cultivo)
    this.trabajadorService.create(this.trabajador)
      .subscribe(trabajador => {
        this.router.navigate(['/trabajadores'])
        swal('Nuevo trabajador', `Trabajador ${trabajador.nombre} creado con éxito!`, 'success')
      }
      );
  }

  update():void{
    this.trabajadorService.update(this.trabajador)
    .subscribe( trabajador => {
      this.router.navigate(['/trabajadores'])
      swal('Trabajador Actualizado', `Trabajador ${trabajador.nombre} actualizado con éxito!`, 'success')
    }

    )
  }

}
