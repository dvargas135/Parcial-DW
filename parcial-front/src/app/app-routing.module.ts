import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookListComponent } from './crud_admin/list/list.component';
import { BookCreateComponent } from './crud_admin/create/create.component';
import { BookUpdateComponent } from './crud_admin/update/update.component';
import { BookDetailsComponent } from './crud_admin/details/details.component';

const routes: Routes = [
	//{ path: '', component: HomeComponent },
	{ path: 'books', component: BookListComponent },
	{ path: 'books/list', component: BookListComponent },
	{ path: 'books/create', component: BookCreateComponent },
	{ path: 'books/update/:id', component: BookUpdateComponent },
	{ path: 'books/details/:id', component: BookDetailsComponent },
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
