import { Component, OnInit } from '@angular/core';

import { revenueBarChart, statData } from './data';

import { InterviewService } from '../../../shared/services/interview.service';
import { UtilisateurService } from '../../../shared/services/utilisateur.service';
import { ChartType } from './profile.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})

/**
 * Contacts-profile component
 */
export class ProfileComponent implements OnInit {
  // bread crumb items
  breadCrumbItems: Array<{}>;

  revenueBarChart: ChartType;
  statData:any;
  utilisateur:any;
email:any;
interviews:any;

  constructor(private utilisateurService:UtilisateurService, private interviewService:InterviewService) { 
    this.email = localStorage.getItem('user');
    
    this.getInterviews();
  }
getInterviews()
{
  this.interviewService.getInterviews().subscribe(data=>{
    this.interviews = data;
    console.log(this.interviews);
  })
}
  ngOnInit() {
    console.log("data::",this.email);
    this.getUserbyEmail(this.email.email);

    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Profile', active: true }];


    // fetches the data
    this._fetchData();
  }

  /**
   * Fetches the data
   */
  private _fetchData() {
    this.revenueBarChart = revenueBarChart;
    this.statData = statData;
  }
  getUserbyEmail(email:any){
    this.utilisateurService.findUserByEmail(email).subscribe(data=>{
      this.utilisateur = data;
      console.log("user",this.utilisateur);
    })
  }

}
