import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { BooklistComponent } from './Book/component/booklist/booklist.component';
import { BookdetailsComponent } from './Book/component/bookdetails/bookdetails.component';
import { AddbookComponent } from './Book/component/addbook/addbook.component';
import { EditbookComponent } from './Book/component/editbook/editbook.component';

@NgModule({
  declarations: [
    AppComponent,
    BooklistComponent,
    BookdetailsComponent,
    AddbookComponent,
    EditbookComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path : '' , redirectTo : '/booklist' ,pathMatch : 'full'},
      {path:'booklist' , component :BooklistComponent },
      {path:'bookdetails/:id' , component :BookdetailsComponent},
      {path:'addbook' , component :AddbookComponent},
      {path:'editbook/:id' , component :EditbookComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
