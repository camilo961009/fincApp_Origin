import { Component, OnInit } from '@angular/core';
import { Trabajador } from './trabajador';
import { TrabajadorService } from './trabajador.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-trabajadores',
  templateUrl: './trabajadores.component.html',
 // styleUrls: ['./trabajadores.component.css']
})
export class TrabajadoresComponent implements OnInit {
  public page:number;

  trabajadores: Trabajador[];
  constructor(private trabajadorService: TrabajadorService) { }

  ngOnInit() {
    this.trabajadorService.getTrabajadores().subscribe(
      trabajadores => this.trabajadores = trabajadores
    );
  }

  delete(trabajador: Trabajador): void {
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al trabajador ${trabajador.nombre} ${trabajador.apellido}?`,
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

        this.trabajadorService.delete(trabajador.cedula).subscribe(
          response => {
            //cli => cli
            this.trabajadores = this.trabajadores.filter(tra => tra !== trabajador)
            swal(
              ' Trabajador Eliminado!',
              `Trabajador ${trabajador.nombre} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }

}
