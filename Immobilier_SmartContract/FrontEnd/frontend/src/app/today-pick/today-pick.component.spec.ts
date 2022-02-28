import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodayPickComponent } from './today-pick.component';

describe('TodayPickComponent', () => {
  let component: TodayPickComponent;
  let fixture: ComponentFixture<TodayPickComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodayPickComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodayPickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
