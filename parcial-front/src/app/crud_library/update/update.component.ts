import { Component, OnInit } from '@angular/core';
import { Library } from '../../models/library';
import { LibraryService } from '../../services/library.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class LibraryUpdateComponent implements OnInit {

  id: number;
  library: Library = new Library();
  constructor(private libraryService: LibraryService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.libraryService.getLibraryById(this.id).subscribe(data => {
      this.library = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.libraryService.updateLibrary(this.id, this.library).subscribe( data =>{
      this.goToLibraryList();
    }
    , error => console.log(error));
  }

  goToLibraryList(){
    this.router.navigate(['/libraries']);
  }
}
