import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map'

const httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class DataService {

  constructor(private http:HttpClient) { }

  getData(countryCode) {
    return this.http.get('http://localhost:8080/getData?countryCode='+countryCode).toPromise();
  }

  getCountries() {
    return this.http.get('http://localhost:8080/getCountries').toPromise();
  }
}
