import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { BookService } from '../../services/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[]

  constructor(private bookService: BookService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks() {
    this.bookService.getBooksList().subscribe(data => {
      this.books = data;
    });
  }

  bookDetails(id: number){
    this.router.navigate(['book-details', id]);
  }

  updateBook(id: number){
    this.router.navigate(['update-book', id]);
  }

  deleteBook(id: number){
    this.bookService.deleteBook(id).subscribe( data => {
      console.log(data);
      this.getBooks();
    })
  }
}
