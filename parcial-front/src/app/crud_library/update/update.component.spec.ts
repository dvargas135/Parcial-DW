import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateComponent } from './update.component';

describe('AdminUpdateComponent', () => {
  let component: AdminUpdateComponent;
  let fixture: ComponentFixture<AdminUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUpdateComponent]
    });
    fixture = TestBed.createComponent(AdminUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});