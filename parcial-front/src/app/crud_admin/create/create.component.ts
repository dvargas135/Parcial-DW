import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../../models/book';
import { BookService } from '../../services/book.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class BookCreateComponent implements OnInit {

  book: Book = new Book();
  constructor(private bookService: BookService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveBook(){
    this.bookService.createBook(this.book).subscribe( data =>{
      console.log(data);
      this.goToBookList();
    },
    error => console.log(error));
  }

  goToBookList(){
    this.router.navigate(['/books']);
  }
  
  onSubmit(){
    console.log(this.book);
    this.saveBook();
  }
}
