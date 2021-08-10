// inbuilt modules
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// services
import { AuthGuardService, NonAuthGuardService } from './shared/services';

// layouts
import { SiteLayoutComponent } from './layout/site-layout/site-layout.component';

// components
// import { LoginComponent, RegisterComponent, ForgotPasswordComponent, ResetPasswordComponent, ActivationComponent,
//   ActivationCoachComponent } from './auth';
// import { PendingCoachListComponent, CoachListComponent, CoachDetailComponent, AddCoachComponent } from './coach-management';
// import { PlayerListComponent, PlayerDetailComponent, AddPlayerComponent } from './player-management';
// import { FanListComponent, FanDetailComponent, AddFanComponent } from './fan-management';
// import { PostListComponent, PostDetailComponent, InactivePostListComponent } from './post-management';
// import { DashboardComponent } from './dashboard/dashboard.component';
import { NotFoundComponent } from './shared/components/not-found/not-found.component';

const routes: Routes = [
  // {
  //   path: 'login',
  //   component: LoginComponent,
  //   canActivate: [NonAuthGuardService]
  // },
  // {
  //   path: 'register',
  //   component: RegisterComponent,
  //   canActivate: [NonAuthGuardService]
  // },
  // {
  //   path: 'forgot-password',
  //   component: ForgotPasswordComponent,
  //   canActivate: [NonAuthGuardService]
  // },
  // {
  //   path: 'reset-password',
  //   component: ResetPasswordComponent,
  // },
  // {
  //   path: 'activate',
  //   component: ActivationComponent,
  // },
  // {
  //   path: 'activate-coach',
  //   component: ActivationCoachComponent,
  // },
  // {
  //   path: '',
  //   component: SiteLayoutComponent,
  //   canActivate: [AuthGuardService],
  //   children: [
  //     { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  //     { path: 'dashboard', component: DashboardComponent },
  //     { path: 'pendingCoachlist', component: PendingCoachListComponent },
  //     { path: 'coach-detail/:id', component: CoachDetailComponent },
  //     { path: 'playerlist', component: PlayerListComponent },
  //     { path: 'player-detail/:id', component: PlayerDetailComponent },
  //     { path: 'coachList', component: CoachListComponent },
  //     { path: 'addPlayer', component: AddPlayerComponent },
  //     { path: 'addCoach', component: AddCoachComponent },
  //     { path: 'fanlist', component: FanListComponent },
  //     { path: 'fan-detail/:id', component: FanDetailComponent },
  //     { path: 'addFan', component: AddFanComponent },
  //     { path: 'activePostList', component: PostListComponent },
  //     { path: 'inactivePostList', component: InactivePostListComponent },
  //     { path: 'post-detail/:id', component: PostDetailComponent },
  //   ]
  // },
  {
    path: '**',
    component: NotFoundComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
