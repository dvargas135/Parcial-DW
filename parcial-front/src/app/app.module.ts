import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './crud_book/list/list.component';
import { BookCreateComponent } from './crud_book/create/create.component';
import { BookDetailsComponent } from './crud_book/details/details.component';
import { BookUpdateComponent } from './crud_book/update/update.component';

import { LibraryListComponent } from './crud_library/list/list.component';
import { LibraryCreateComponent } from './crud_library/create/create.component';
import { LibraryDetailsComponent } from './crud_library/details/details.component';
import { LibraryUpdateComponent } from './crud_library/update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookCreateComponent,
    BookDetailsComponent,
    BookUpdateComponent,
    LibraryListComponent,
    LibraryCreateComponent,
    LibraryDetailsComponent,
    LibraryUpdateComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
