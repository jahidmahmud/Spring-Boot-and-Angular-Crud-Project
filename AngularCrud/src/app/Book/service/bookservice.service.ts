import { Injectable } from '@angular/core';
import { Book } from '../models/book.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8080/api/books'

@Injectable({
  providedIn: 'root'
})
export class BookserviceService {


  constructor(private http: HttpClient) { }


  ///spring boot api
  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(baseUrl);
  }

  getSingleBook(id: number): Observable<Book> {
    return <Observable<Book>>this.http.get(`${baseUrl}/${id}`);
  }

  addBooks(data: Book): Observable<Book> {
    return <Observable<Book>>this.http.post(baseUrl, data);
  }

  updateBooks(data: Book): Observable<Book> {
    return <Observable<Book>>this.http.put(baseUrl, data);
  }

  deleteBook(id:number): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

}
