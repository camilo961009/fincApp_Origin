import { Component, OnInit } from '@angular/core';
import {Cosecha} from './cosecha'
import {CosechaService} from './cosecha.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'


@Component({
  selector: 'app-formulario2',
  templateUrl: './formulario2.component.html'
})
export class Formulario2Component implements OnInit {
  lista:string[]=["Pimenton","Abichuela","Ahuyama", "Pepino", "Lulo"];

  private cosecha: Cosecha = new Cosecha()
  private titulo:string = "Crear Cosecha";
  seleccionado:string= "";
  value:number= 0;

  constructor(private cosechaService: CosechaService,
  private router: Router,
  private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarCosecha();
  }

  capturar(){
    this.value=this.cosecha.cultivo;
  if(this.value=8){
    this.cosecha.cultivo=8;
  }else if(this.value=9){
    this.cosecha.cultivo=9;
  }else if(this.value=10){
    this.cosecha.cultivo=10;
  }else if(this.value=11){
    this.cosecha.cultivo=11;
  }else if(this.value=12){
    this.cosecha.cultivo=12;
  }
  }

  cargarCosecha(): void{
    this.activatedRoute.params.subscribe(params => {
      let idcosecha = params['idcosecha']
      if(idcosecha){
        this.cosechaService.getCosecha(idcosecha).subscribe( (cosecha) => this.cosecha = cosecha)
      }
    })
  }

  create(): void {
   
    this.cosechaService.create(this.cosecha)
      .subscribe(cosecha => {
        this.router.navigate(['/cosechas'])
        swal('Nueva cosecha', `Cosecha con ${cosecha.cantidad} de platas creada con éxito!`, 'success')
      }
      );
  }

  update():void{
    this.cosechaService.update(this.cosecha)
    .subscribe( cosecha => {
      this.router.navigate(['/cosechas'])
      swal('Cosecha Actualizada', `Cosecha con ${cosecha.cantidad} de matas actualizado con éxito!`, 'success')
    }

    )
  }


}
