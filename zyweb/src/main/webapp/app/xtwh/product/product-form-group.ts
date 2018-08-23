import {FormBuilder, FormGroup} from '@angular/forms';
import {OnInit} from '@angular/core';

export class ProductFormGroup extends FormGroup implements OnInit{
  constructor(private fb: FormBuilder){
    super();
  }
  ngOnInit(){

  }
}
