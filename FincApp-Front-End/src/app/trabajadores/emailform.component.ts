import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
import { EmailRequest } from './emailRequest';
import { TrabajadorService } from './trabajador.service';

@Component({
  selector: 'app-emailform',
  templateUrl: './emailform.component.html',
  styleUrls: ['./emailform.component.css']
})
export class EmailformComponent implements OnInit {

  private titulo:string = "Enviar Email";
  private emailRequest: EmailRequest = new EmailRequest()

  constructor(private trabajadorService: TrabajadorService,
    private router: Router,
   private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

  sendEmail(): void {
    this.trabajadorService.sendEmail(this.emailRequest)
      .subscribe(emailrequest => {
        this.router.navigate(['/trabajadores'])
        swal('Email Enviado', `Exitosamente`, 'success')
      }
      );
  }

}
