import { Component, OnInit } from '@angular/core';
import { Cosecha } from './cosecha';
import { CosechaService } from './cosecha.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-cosechas',
  templateUrl: './cosechas.component.html'
})
export class CosechasComponent implements OnInit {

  public page:number;

  cosechas:Cosecha[];

  constructor(private cosechaService:CosechaService) { }

  

  ngOnInit() {
    this.cosechaService.getCosechas().subscribe(
      cosechas => this.cosechas = cosechas
    );
  }

  delete(cosecha: Cosecha): void {
    
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar la cosecha de ${cosecha.cantidad} con ${cosecha.valor} de valor?`,
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

        this.cosechaService.delete(cosecha.idcosecha).subscribe(
          
          response => {
            //cli => cli
            this.cosechas = this.cosechas.filter(cos => cos !== cosecha)
            swal(
              ' Cosecha Eliminada!',
              `Cosecha ${cosecha.cantidad} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }


}
