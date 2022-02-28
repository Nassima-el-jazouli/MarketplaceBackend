import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminManagmentComponent } from './admin-managment/admin-managment.component';
import { AnnouncementManagmentComponent } from './announcement-managment/announcement-managment.component';
import { AuthorsComponent } from './authors/authors.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ExploreComponent } from './explore/explore.component';
import { FAQComponent } from './faq/faq.component';
import { HelpCenterComponent } from './help-center/help-center.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProfileDetailsComponent } from './profile-details/profile-details.component';
import { ProfileComponent } from './profile/profile.component';
import { RequestsComponent } from './requests/requests.component';
import { SignupComponent } from './signup/signup.component';
import { TransactionComponent } from './transaction/transaction.component';
import {AnnonceComponent} from './annonce/annonce.component';
import {AnnouncesListComponent} from './announces-list/announces-list.component';
import { EditAdminComponent } from './edit-admin/edit-admin.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { RoleGuard } from './_services/role.guard';
import { TokenStorageGuard } from './_services/token-storage.guard';



const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'explore', component: ExploreComponent},
  {path: 'transactions', component: TransactionComponent, canActivate: [TokenStorageGuard]},
  {path: 'authors', component: AuthorsComponent},
  {path: 'help', component: HelpCenterComponent},
  {path: 'contact', component: ContactUsComponent},
  {path: 'faq', component: FAQComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'profileDetails', component: ProfileDetailsComponent },
  {path: 'announcementManagment', component: AnnouncementManagmentComponent},
  {path: 'requestsManagment', component: RequestsComponent },
  {path: 'announce', component: AnnonceComponent , canActivate: [TokenStorageGuard]},
  {path: 'announces-list', component: AnnouncesListComponent , canActivate: [TokenStorageGuard]},
  {path: 'adminManagment', component: AdminManagmentComponent, canActivate: [RoleGuard] },
  {path: 'editAdmin/:id', component: EditAdminComponent, canActivate: [RoleGuard] },
  {path: 'addAdmin', component: AddAdminComponent, canActivate: [RoleGuard] },
  {path: 'aboutUs',component: AboutUsComponent}






];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
