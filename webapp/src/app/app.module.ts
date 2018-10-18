import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { NvD3Module } from 'ng2-nvd3';
import { DataService } from './data.service';

import { AppComponent } from './app.component';
import { GraphComponent } from './graph/graph.component';
import 'd3';
import 'nvd3';


@NgModule({
  declarations: [
    AppComponent,
    GraphComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    NvD3Module
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
