import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Auxiliar} from './auxiliar';

@Injectable()
export class AuxiliarService {

  private urlEndPoint: string = 'http://localhost:8080/employeeHarvest/trabajadoresCosechas';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})


  constructor(private http: HttpClient) { }

  
  getAuxiliares(): Observable<Auxiliar[]> {
    //return of(CLIENTES);

    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Auxiliar[])
    );
  }

  create(auxiliar: Auxiliar) : Observable<Auxiliar> {
    return this.http.post<Auxiliar>(this.urlEndPoint, auxiliar, {headers: this.httpHeaders})
  }

  getAuxiliar(cedula): Observable<Auxiliar>{
    return this.http.get<Auxiliar>(`${this.urlEndPoint}/${cedula}`)
  }

  update(auxiliar: Auxiliar): Observable<Auxiliar>{
    return this.http.put<Auxiliar>(`${this.urlEndPoint}/${auxiliar.cedula}`, auxiliar, {headers: this.httpHeaders})
  }

  delete(cedula: number): Observable<Auxiliar>{
    return this.http.delete<Auxiliar>(`${this.urlEndPoint}/${cedula}`, {headers: this.httpHeaders})
  }



}
