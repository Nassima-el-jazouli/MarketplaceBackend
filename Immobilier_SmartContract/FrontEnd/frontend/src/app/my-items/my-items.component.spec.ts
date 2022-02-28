import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyItemsComponent } from './my-items.component';

describe('MyItemsComponent', () => {
  let component: MyItemsComponent;
  let fixture: ComponentFixture<MyItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyItemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
