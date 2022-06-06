import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book.model';
import { BookserviceService } from '../../service/bookservice.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-editbook',
  templateUrl: './editbook.component.html',
  styleUrls: ['./editbook.component.css']
})
export class EditbookComponent implements OnInit {

  constructor(private bookService:BookserviceService,
              private route:ActivatedRoute,
              private router:Router) { }
  book:Book={
    id:0,
    name: '',
    author :''
  }

  ngOnInit(): void {
    const routeParam=this.route.snapshot.paramMap;
    const id=Number(routeParam.get('id'))
    this.bookService.getSingleBook(id)
    .subscribe(data=>this.book=data);
  }

  updateUser=()=>{
    this.bookService.updateBooks(this.book)
    .subscribe(data=>{
      console.log(data);
    },
    error => {
      console.log(error);
    });
  }

}
