import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DataService } from '../data.service';
declare let d3: any;

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css', '../../../node_modules/nvd3/build/nv.d3.css'],
  encapsulation: ViewEncapsulation.None
})
export class GraphComponent implements OnInit {

  constructor(private dataService: DataService) { }

  options;
  data;
  countries;
  currentCountry='ARG';

  onChange(event) {
    this.currentCountry=event.target.value;
    this.loadData();
  }

  loadData() {
    var myPromise = this.dataService.getData(this.currentCountry);
    myPromise.then((value) => {
      this.data = value;
    });
  }


  ngOnInit() {
    var countryPromise = this.dataService.getCountries();
    countryPromise.then((value) => {
      this.countries = value;
    });

    this.loadData();

    this.options = {
      chart: {
        type: 'lineChart',
        height: 450,
        margin : {
          top: 20,
          right: 40,
          bottom: 80,
          left: 55
        },
        x: function(d){return d.date;},
        y: function(d){return d.value;},
        showValues: true,
        valueFormat: function(d){
          return d3.format(',.4f')(d);
        },
        duration: 3000,
        xAxis: {
          tickFormat: function(d) {
              return d3.time.format('%m/%Y')(new Date(d))
          },
          ticks: 10,
          rotateLabels: 35,
          showMaxMin: false,
        },
        yAxis: {
          tickFormat: function(d){
              return d3.format(',.1f')(d);
          },
          axisLabelDistance: -10,
          showMaxMin: false
        }
      }
    }
  }
}
