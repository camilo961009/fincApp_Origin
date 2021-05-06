import { Component, OnInit } from '@angular/core';
import { Insumo } from './insumo';
import { InsumoService } from './insumo.service';
import swal from 'sweetalert2'


@Component({
  selector: 'app-insumos',
  templateUrl: './insumos.component.html'
})
export class InsumosComponent implements OnInit {

  public page:number;

  insumos:Insumo[];


  constructor(private insumoService:InsumoService) { }

  ngOnInit() {
    this.insumoService.getInsumos().subscribe(
      insumos => this.insumos=insumos
    );
  }


  delete(insumo: Insumo): void {
    
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar el insumo  ${insumo.nombre} con ${insumo.precio} de valor?`,
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

        this.insumoService.delete(insumo.idinsumo).subscribe(
          
          response => {
            //cli => cli
            this.insumos = this.insumos.filter(ins => ins !== insumo)
            swal(
              ' Insumo Eliminado!',
              `Insumo ${insumo.nombre} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }



}
