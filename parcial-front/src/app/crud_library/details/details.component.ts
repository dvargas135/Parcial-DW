import { Component, OnInit } from '@angular/core';
import { Library } from '../../models/library';
import { LibraryService } from '../../services/library.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class LibraryDetailsComponent implements OnInit{

  id: number
  library: Library
  constructor(private route: ActivatedRoute, private libraryService: LibraryService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.library = new Library();
    this.libraryService.getLibraryById(this.id).subscribe( data => {
      this.library = data;
    });
  }
}
