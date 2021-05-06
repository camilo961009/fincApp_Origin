import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Cultivo } from './cultivo';


@Injectable()
export class CultivoService {

  private urlEndPoint: string = 'http://localhost:8080/cultivation/cultivos';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})


  constructor(private http: HttpClient) { }

  getCultivos(): Observable<Cultivo[]>{    
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Cultivo[])
    );
  }
  
  create(cultivo: Cultivo) : Observable<Cultivo> {
    console.log(cultivo)
    return this.http.post<Cultivo>(this.urlEndPoint, cultivo, {headers: this.httpHeaders})
  }

  getCultivo(idcultivo): Observable<Cultivo>{
    return this.http.get<Cultivo>(`${this.urlEndPoint}/${idcultivo}`)
  }

  update(cultivo: Cultivo): Observable<Cultivo>{
    
    return this.http.put<Cultivo>(`${this.urlEndPoint}/${cultivo.idcultivo}`, cultivo, {headers: this.httpHeaders})
  }

  delete(idcultivo: number): Observable<Cultivo>{
    
    return this.http.delete<Cultivo>(`${this.urlEndPoint}/${idcultivo}`, {headers: this.httpHeaders})
  }


}
