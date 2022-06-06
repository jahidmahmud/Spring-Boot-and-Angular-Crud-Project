import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book.model';
import { ActivatedRoute,Router } from '@angular/router';
import { BookserviceService } from '../../service/bookservice.service';

@Component({
  selector: 'app-bookdetails',
  templateUrl: './bookdetails.component.html',
  styleUrls: ['./bookdetails.component.css']
})
export class BookdetailsComponent implements OnInit {
  book :Book={
    id: 0,
    name:'',
    author:''
  }

  constructor(private bookService:BookserviceService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    const routeParam=this.route.snapshot.paramMap;
    const id=Number(routeParam.get('id'))
    this.bookService.getSingleBook(id)
    .subscribe(data=>this.book=data);
  }

}
