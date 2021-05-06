import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Insumo } from './insumo';

@Injectable()
export class InsumoService {

  private urlEndPoint: string = 'http://localhost:8080/insumo/insumos';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})



  constructor(private http: HttpClient) { }

  getInsumos(): Observable<Insumo[]>{    
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Insumo[])
    );
  }

  create(insumo: Insumo) : Observable<Insumo> {
    
    return this.http.post<Insumo>(this.urlEndPoint, insumo, {headers: this.httpHeaders})
  }

  getInsumo(idinsumo): Observable<Insumo>{
    return this.http.get<Insumo>(`${this.urlEndPoint}/${idinsumo}`)
  }

  update(insumo: Insumo): Observable<Insumo>{
    
    return this.http.put<Insumo>(`${this.urlEndPoint}/${insumo.idinsumo}`, insumo, {headers: this.httpHeaders})
  }

  delete(idinsumo: number): Observable<Insumo>{
  
    return this.http.delete<Insumo>(`${this.urlEndPoint}/${idinsumo}`, {headers: this.httpHeaders})
  }

}
