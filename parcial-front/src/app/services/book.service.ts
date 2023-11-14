import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = environment.apiUrl + "books";

  constructor(private httpClient: HttpClient) { }

  getBooksList(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseUrl}`);
  }

  createBook(Book: Book): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}/create`, Book);
  }

  getBookById(id: number): Observable<Book>{
    return this.httpClient.get<Book>(`${this.baseUrl}/${id}`);
  }

  updateBook(id: number, Book: Book): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`, Book);
  }

  deleteBook(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
