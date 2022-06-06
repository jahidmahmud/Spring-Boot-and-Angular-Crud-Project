import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book.model';
import { BookserviceService } from '../../service/bookservice.service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  book:Book[]=[];


  constructor(private bookService:BookserviceService) { }

  ngOnInit(): void {
    this.getBooks();
  }
  getBooks():void{
    this.bookService.getAllBooks()
    .subscribe(data=>{
      this.book=data;
    },
    error => {
      console.log(error);
    });
  }
  delete=(id:number)=>{
    this.bookService.deleteBook(id)
    .subscribe(data=>{
      console.log(data)
    });
}
}
