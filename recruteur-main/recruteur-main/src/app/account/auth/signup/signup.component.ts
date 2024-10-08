import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { Utilisateur } from 'src/app/shared/classes/utilisateur';
import { environment } from '../../../../environments/environment';
import { AuthenticationService } from '../../../core/services/auth.service';
import { UserProfileService } from '../../../core/services/user.service';
import { UtilisateurService } from '../../../shared/services/utilisateur.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  utilisateur: Utilisateur = {} as Utilisateur;
  signupForm: UntypedFormGroup;
  submitted: boolean = false;
  error: string = '';
  successmsg: boolean = false;

  year: number = new Date().getFullYear();

  constructor(private formBuilder: UntypedFormBuilder, private route: ActivatedRoute, private router: Router, private authenticationService: AuthenticationService, private userService: UserProfileService, private utilisateurService: UtilisateurService) { }

  ngOnInit() {
    this.utilisateur.grade = "Admin";
    this.signupForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  get f() { return this.signupForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.signupForm.invalid) {
      return;
    }

    this.utilisateurService.addUtilisateur(this.utilisateur).subscribe(data => {
      if (environment.defaultauth === 'firebase') {
        this.authenticationService.register(this.utilisateur.email, this.utilisateur.mdp).then((res: any) => {
          this.successmsg = true;
          if (this.successmsg) {
            this.router.navigate(['/dashboard']);
          }
        }).catch(error => {
          this.error = error ? error : '';
        });
      }
    });
  }
}
