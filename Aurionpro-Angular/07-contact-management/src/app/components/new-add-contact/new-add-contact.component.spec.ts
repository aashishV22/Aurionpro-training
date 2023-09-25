import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAddContactComponent } from './new-add-contact.component';

describe('NewAddContactComponent', () => {
  let component: NewAddContactComponent;
  let fixture: ComponentFixture<NewAddContactComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewAddContactComponent]
    });
    fixture = TestBed.createComponent(NewAddContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
