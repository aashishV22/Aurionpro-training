import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaughterComponent } from './daughter.component';

describe('DaughterComponent', () => {
  let component: DaughterComponent;
  let fixture: ComponentFixture<DaughterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DaughterComponent]
    });
    fixture = TestBed.createComponent(DaughterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
