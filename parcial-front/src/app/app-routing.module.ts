import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookListComponent } from './crud_book/list/list.component';
import { BookCreateComponent } from './crud_book/create/create.component';
import { BookUpdateComponent } from './crud_book/update/update.component';
import { BookDetailsComponent } from './crud_book/details/details.component';

import { LibraryListComponent } from './crud_library/list/list.component';
import { LibraryCreateComponent } from './crud_library/create/create.component';
import { LibraryUpdateComponent } from './crud_library/update/update.component';
import { LibraryDetailsComponent } from './crud_library/details/details.component';

const routes: Routes = [
	//{ path: '', component: ___ },
	{ path: 'books', component: BookListComponent },
	{ path: 'books/list', component: BookListComponent },
	{ path: 'books/create', component: BookCreateComponent },
	{ path: 'books/update/:id', component: BookUpdateComponent },
	{ path: 'books/details/:id', component: BookDetailsComponent },
	{ path: 'libraries', component: LibraryListComponent },
	{ path: 'libraries/list', component: LibraryListComponent },
	{ path: 'libraries/create', component: LibraryCreateComponent },
	{ path: 'libraries/update/:id', component: LibraryUpdateComponent },
	{ path: 'libraries/details/:id', component: LibraryDetailsComponent },
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
