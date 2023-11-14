import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListComponent } from './list.component';

describe('AdminListComponent', () => {
  let component: AdminListComponent;
  let fixture: ComponentFixture<AdminListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminListComponent]
    });
    fixture = TestBed.createComponent(AdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
