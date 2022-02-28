import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementManagmentComponent } from './announcement-managment.component';

describe('AnnouncementManagmentComponent', () => {
  let component: AnnouncementManagmentComponent;
  let fixture: ComponentFixture<AnnouncementManagmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncementManagmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnouncementManagmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
