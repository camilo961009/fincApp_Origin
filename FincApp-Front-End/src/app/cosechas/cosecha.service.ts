import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Cosecha } from './cosecha';

@Injectable()
export class CosechaService {

  private urlEndPoint: string = 'http://localhost:8080/harvest/cosechas';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})


  constructor(private http: HttpClient) { }

  getCosechas(): Observable<Cosecha[]>{    
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Cosecha[])
    );
  }

  create(cosecha: Cosecha) : Observable<Cosecha> {
    
    return this.http.post<Cosecha>(this.urlEndPoint, cosecha, {headers: this.httpHeaders})
  }

  getCosecha(idcosecha): Observable<Cosecha>{
    return this.http.get<Cosecha>(`${this.urlEndPoint}/${idcosecha}`)
  }

  update(cosecha: Cosecha): Observable<Cosecha>{
    
    return this.http.put<Cosecha>(`${this.urlEndPoint}/${cosecha.idcosecha}`, cosecha, {headers: this.httpHeaders})
  }

  delete(idcosecha: number): Observable<Cosecha>{
    
    return this.http.delete<Cosecha>(`${this.urlEndPoint}/${idcosecha}`, {headers: this.httpHeaders})
  }



}
