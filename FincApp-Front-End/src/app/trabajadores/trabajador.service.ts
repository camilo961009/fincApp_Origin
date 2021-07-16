import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Trabajador} from './trabajador';
import {EmailRequest} from './emailRequest';
//import {TRABAJADORES} from './trabajadores.json'

@Injectable()
export class TrabajadorService {

  private urlEndPoint: string = 'http://localhost:8080/employee/trabajadores';
  private urlEmail: string = 'http://localhost:8080/employee/trabajadores/email';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})


  constructor(private http: HttpClient) {

    
   }

  getTrabajadores(): Observable<Trabajador[]> {
    //return of(CLIENTES);

    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Trabajador[])
    );
    
  }

  create(trabajador: Trabajador) : Observable<Trabajador> {
    return this.http.post<Trabajador>(this.urlEndPoint, trabajador, {headers: this.httpHeaders})
  }

  getTrabajador(cedula): Observable<Trabajador>{
    return this.http.get<Trabajador>(`${this.urlEndPoint}/${cedula}`)
  }

  update(trabajador: Trabajador): Observable<Trabajador>{
    return this.http.put<Trabajador>(`${this.urlEndPoint}/${trabajador.cedula}`, trabajador, {headers: this.httpHeaders})
  }

  delete(cedula: number): Observable<Trabajador>{
    return this.http.delete<Trabajador>(`${this.urlEndPoint}/${cedula}`, {headers: this.httpHeaders})
  }

  sendEmail(emailRequest: EmailRequest):Observable<EmailRequest>{
    return this.http.post<EmailRequest>(this.urlEmail,emailRequest,{headers: this.httpHeaders})
  }


}
