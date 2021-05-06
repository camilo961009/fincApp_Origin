import { Component, OnInit } from '@angular/core';
import { Auxiliar } from './auxiliar';
import { AuxiliarService } from './auxiliar.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-auxiliares',
  templateUrl: './auxiliares.component.html'
})
export class AuxiliaresComponent implements OnInit {

  public page:number;

  auxiliares: Auxiliar[];

  constructor(private auxiliarService: AuxiliarService ) { }

  ngOnInit() {
    this.auxiliarService.getAuxiliares().subscribe(
      auxiliares => this.auxiliares = auxiliares
    );
  }

  delete(auxiliar: Auxiliar): void {
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al auxiliar ${auxiliar.nombre} ${auxiliar.apellido}?`,
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

        this.auxiliarService.delete(auxiliar.cedula).subscribe(
          response => {
            //cli => cli
            this.auxiliares = this.auxiliares.filter(aux => aux !== auxiliar)
            swal(
              ' Auxiliar Eliminado!',
              `Auxiliar ${auxiliar.nombre} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }

}
