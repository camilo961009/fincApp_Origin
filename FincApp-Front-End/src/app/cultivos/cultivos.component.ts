import { Component, OnInit } from '@angular/core';
import { Cultivo } from './cultivo';
import { CultivoService } from './cultivo.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-cultivos',
  templateUrl: './cultivos.component.html'
})
export class CultivosComponent implements OnInit {

  public page:number;

  cultivos: Cultivo[];
  


  constructor(private cultivoService:CultivoService) { }

  ngOnInit() {
    this.cultivoService.getCultivos().subscribe(
      cultivos => this.cultivos = cultivos
    );
  }

  
  delete(cultivo: Cultivo): void {
    
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al Cultivo de ${cultivo.tipoCultivo} con ${cultivo.cantidadDeMatas} de matas?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {
      if (result.value) {

        this.cultivoService.delete(cultivo.idcultivo).subscribe(
          
          response => {
            //cli => cli
            this.cultivos = this.cultivos.filter(cul => cul !== cultivo)
            swal(
              ' Cultivo Eliminado!',
              `Cultivo ${cultivo.tipoCultivo} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }


}
