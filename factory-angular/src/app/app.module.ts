import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ReservationComponent } from './reservation/reservation.component';
import { LieuComponent } from './lieu/lieu.component';
import { CategorieComponent } from './categorie/categorie.component';
import { ActiviteComponent } from './activite/activite.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { ActiviteDetailComponent } from './activite-detail/activite-detail.component';
import { ActivitesComponent } from './activites/activites.component';
import { PropositionComponent } from './proposition/proposition.component';


// Config des routes :
const routes: Routes = [
{ path: 'accueil', component: AccueilComponent },
{ path: 'reservation', component: ReservationComponent },
{ path: 'lieu', component: LieuComponent },
{ path: 'lieu/:id', component: LieuComponent },
{ path: 'categorie', component: CategorieComponent },
{ path: 'activite', component: ActiviteComponent },
{ path: 'activite/:id', component: ActiviteDetailComponent, pathMatch: 'full' },
{ path: 'activites/:id', component: ActivitesComponent },
{ path: 'proposition', component: PropositionComponent },
{ path: '', redirectTo: 'accueil', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    ReservationComponent,
    LieuComponent,
    CategorieComponent,
    ActiviteComponent,
    ActiviteDetailComponent,
    ActiviteComponent,
    ActivitesComponent,
    PropositionComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
