import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book.model';
import { BookserviceService } from '../../service/bookservice.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {
  userForm: boolean = true;
  newBook:Book={
    id: 0,
    name:'',
    author: ''
  }

  constructor(private bookService:BookserviceService) { }

  ngOnInit(): void {
  }

  saveBook(): void {
    this.bookService.addBooks(this.newBook)
    .subscribe(data=>{
      console.log(data);
    },
    error => {
      console.log(error);
    });
    this.userForm=false
  }

}
