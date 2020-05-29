import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { StudentComponent } from './components/student/student.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {DataTablesModule} from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import * as bootstrap from "bootstrap";
import * as $ from "jquery";

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    AppRoutingModule,
    DataTablesModule,
    HttpClientModule,
    FormsModule,    
  //   RouterModule.forRoot([
  //     {path: 'student',component: StudentComponent}
  //  ])    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
