import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/modelo/experiencia';
import { SExperienciaService } from 'src/app/servicios/s-experiencia.service';

@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit {

  expLab : Experiencia = null;

  constructor(private sExperiencia: SExperienciaService, private activatedRouter: ActivatedRoute,
    private router: Router){ }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperiencia.detail(id).subscribe(
      {
        next: data=>{
          this.expLab = data;
      },
        error: err=> {
          alert("Error en actualizar datos");
          this.router.navigate(['']);
        }
        
      });
    
  }

  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperiencia.update(id, this.expLab).subscribe(
      {
        next: data => {
        this.router.navigate(['']);
      }, 
        error: err =>{
        alert("Error en actualizar datos");
        this.router.navigate(['']);
        }

      });
  }


}
