import { Component, OnInit } from '@angular/core';
import { Library } from '../../models/library';
import { LibraryService } from '../../services/library.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-library-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class LibraryListComponent implements OnInit {

  libraries: Library[]

  constructor(private libraryService: LibraryService,
    private router: Router) { }

  ngOnInit(): void {
    this.getLibrarys();
  }

  private getLibrarys() {
    this.libraryService.getLibrarysList().subscribe(data => {
      this.libraries = data;
    });
  }

  libraryDetails(id: number){
    this.router.navigate(['library-details', id]);
  }

  updateLibrary(id: number){
    this.router.navigate(['update-library', id]);
  }

  deleteLibrary(id: number){
    this.libraryService.deleteLibrary(id).subscribe( data => {
      console.log(data);
      this.getLibrarys();
    })
  }
}
