import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Control } from './control';

@Injectable()
export class ControlService {

  private urlEndPoint: string = 'http://localhost:8080/control/controles';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})



  constructor(private http: HttpClient) { }

  getControles(): Observable<Control[]>{    
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Control[])
    );
  }

  create(control: Control) : Observable<Control> {
    
    return this.http.post<Control>(this.urlEndPoint, control, {headers: this.httpHeaders})
  }

  getControl(idcontrol): Observable<Control>{
    return this.http.get<Control>(`${this.urlEndPoint}/${idcontrol}`)
  }

  update(control: Control): Observable<Control>{
    
    return this.http.put<Control>(`${this.urlEndPoint}/${control.idcontrol}`, control, {headers: this.httpHeaders})
  }

  delete(idcontrol: number): Observable<Control>{
    
    return this.http.delete<Control>(`${this.urlEndPoint}/${idcontrol}`, {headers: this.httpHeaders})
  }


}
