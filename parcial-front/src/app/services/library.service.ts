import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Library } from '../models/library';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  private baseUrl = environment.apiUrl + "libraries";

  constructor(private httpClient: HttpClient) { }

  getLibrarysList(): Observable<Library[]>{
    return this.httpClient.get<Library[]>(`${this.baseUrl}`);
  }

  createLibrary(Library: Library): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}/create`, Library);
  }

  getLibraryById(id: number): Observable<Library>{
    return this.httpClient.get<Library>(`${this.baseUrl}/${id}`);
  }

  updateLibrary(id: number, Library: Library): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`, Library);
  }

  deleteLibrary(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
