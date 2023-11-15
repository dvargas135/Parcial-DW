import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Library } from '../../models/library';
import { LibraryService } from '../../services/library.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class LibraryCreateComponent implements OnInit {

  library: Library = new Library();
  constructor(private libraryService: LibraryService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveLibrary(){
    this.libraryService.createLibrary(this.library).subscribe( data =>{
      console.log(data);
      this.goToLibraryList();
    },
    error => console.log(error));
  }

  goToLibraryList(){
    this.router.navigate(['/libraries']);
  }
  
  onSubmit(){
    console.log(this.library);
    this.saveLibrary();
  }
}
