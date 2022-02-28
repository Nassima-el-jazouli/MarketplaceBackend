import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnnonceComponent } from './annonce/annonce.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ExploreComponent } from './explore/explore.component';
import { TransactionComponent } from './transaction/transaction.component';
import { ProfileComponent } from './profile/profile.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AuthorsComponent } from './authors/authors.component';
import { FAQComponent } from './faq/faq.component';
import { HelpCenterComponent } from './help-center/help-center.component';
import { SignupComponent } from './signup/signup.component';
import { OperationComponent } from './operation/operation.component';
import { RequestsComponent } from './requests/requests.component';
import { AdminManagmentComponent } from './admin-managment/admin-managment.component';
import { AnnouncementManagmentComponent } from './announcement-managment/announcement-managment.component';
import { ProfileDetailsComponent } from './profile-details/profile-details.component';
import { TodayPickComponent } from './today-pick/today-pick.component';
import { AnnouncesListComponent } from './announces-list/announces-list.component';
import { AdminsComponent } from './admins/admins.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { EditAdminComponent } from './edit-admin/edit-admin.component';
import { AboutUsComponent } from './about-us/about-us.component';

@NgModule({
  declarations: [
    AppComponent,
    AnnonceComponent,
    FooterComponent,
    HeaderComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    ExploreComponent,
    TransactionComponent,
    ProfileComponent,
    ContactUsComponent,
    AuthorsComponent,
    FAQComponent,
    HelpCenterComponent,
    SignupComponent,
    OperationComponent,
    RequestsComponent,
    AdminManagmentComponent,
    AnnouncementManagmentComponent,
    ProfileDetailsComponent,
    TodayPickComponent,
    AnnouncesListComponent,
    AdminsComponent,
    AddAdminComponent,
    EditAdminComponent,
    AboutUsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
    timeOut: 150000, // 15 seconds
    closeButton: true,
    progressBar: true,
  }),
  AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
