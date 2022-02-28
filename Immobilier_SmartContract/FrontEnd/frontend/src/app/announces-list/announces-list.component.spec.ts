import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncesListComponent } from './announces-list.component';

describe('AnnouncesListComponent', () => {
  let component: AnnouncesListComponent;
  let fixture: ComponentFixture<AnnouncesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncesListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnouncesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
