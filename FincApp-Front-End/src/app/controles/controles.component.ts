import { Component, OnInit } from '@angular/core';
import { Control} from './control';
import { ControlService } from './control.service';
import swal from 'sweetalert2'


@Component({
  selector: 'app-controles',
  templateUrl: './controles.component.html'
})
export class ControlesComponent implements OnInit {

  public page:number;

  controles:Control[];

  constructor(private controlService:ControlService) { }

  ngOnInit() {
    this.controlService.getControles().subscribe(
      controles=>this.controles=controles
    )
  }

  delete(control: Control): void {
    
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar el control ${control.nombre} de tipo ${control.tipo} ?`,
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

        this.controlService.delete(control.idcontrol).subscribe(
          
          response => {
            //cli => cli
            this.controles = this.controles.filter(con => con !== control)
            swal(
              ' Control Eliminado!',
              `Control ${control.nombre} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }


}
