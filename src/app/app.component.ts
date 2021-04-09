import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { EventEmitter } from '@angular/core';
import {Task} from './task'
import { NONE_TYPE } from '@angular/compiler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularAssignment';
  closeResult = '';
  listOfTask : Task[] = [];
  listOfInProgress : Task[] = [];
  listOfCompleted : Task[] = [];
  listCompleted : string[] = [];
  titleOfTask : string = '';
  description : string = '';
  completionDate : string = '';
  priority : string = '';
  constructor(private modalService: NgbModal) { }
  
  // ngOnInit(){
  //   setInterval(() => {
  //     this.addCompleteTask(); 
  //     }, 5000);
  // }

  open(content : any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }


  todos  = [
    'Get to work',
    'Pick up groceries',
    'Go home',
    'Fall asleep'
  ];
  
  completed : string[] = [
    'Get up',
    'Brush teeth',
    'Take a shower',
    'Check e-mail',
    'Walk dog'
  ];
  
  drop(event: CdkDragDrop<any>) {
    if (event.previousContainer != event.container) {
      event.previousContainer.data[event.previousIndex].setStatus("In Progress");
      console.log(event.previousContainer.data[event.previousIndex]);
      transferArrayItem(event.previousContainer.data,
      event.container.data,
      event.previousIndex, event.currentIndex); 
    }
    else {
     // moveItemInArray(event.container.data,
      //   event.previousIndex,
      //   event.currentIndex);
    }  
  }
  
  addTask(){
    this.title  = (<HTMLInputElement>document.getElementById("title")).value;
    this.description = (<HTMLInputElement>document.getElementById("description")).value;
    this.completionDate = (<HTMLInputElement>document.getElementById("dateOfCompletion")).value;
    this.priority = (<HTMLInputElement>document.getElementById("priority")).value;
    this.listOfTask.push(new Task(this.title,this.description , "New", this.priority ,this.completionDate));
    console.log(this.listOfTask);
    this.title = '';
    this.description ='';
    this.completionDate = '';
    this.priority = '';
  }

  updaetTask(){
    this.title  = (<HTMLInputElement>document.getElementById("updateTitle")).value;
    this.completionDate = (<HTMLInputElement>document.getElementById("updateDateOfCompletion")).value;
    this.priority = (<HTMLInputElement>document.getElementById("updatePriority")).value;
    let item : Task = this.listOfTask[0];
    for (let index = 0 ; index < this.listOfTask.length ; index ++){
      if(this.listOfTask[index].getTitle() == this.title){
        item = this.listOfTask[index];
      }
    }
    if (this.completionDate != '') {
      item.setCompletionDate(this.completionDate)
    }
    if (this.priority != '') {
      item.setPriority(this.priority);
    }
    console.log(this.listOfTask);
  }

  removeTask(){
    let title : string  = (<HTMLInputElement>document.getElementById("updateTitle")).value;
    this.listOfTask = this.listOfTask.filter(item => item.title != title);
    console.log(this.listOfTask);
  }

  sleep(delay:number) {
    var start = new Date().getTime();
    while (new Date().getTime() < start + delay);
  }

  addCompleteTask(){
    if (this.listOfInProgress.length > 0){
      this.listOfInProgress[0].setStatus("Completed");
      this.sleep(3000);
      transferArrayItem(this.listOfInProgress,
        this.listOfCompleted,
        0, this.listOfCompleted.length);
    }
  }

  giveColor(item:Task){
    let box : any =  (<HTMLInputElement>document.getElementById("box"));
    if (item.priority == "High") {
      box.style.backgroundColor = "green";
    }
    else if(item.priority == "Medium") {
      box.style.backgroundColor = "orange";
    } 
    else if(item.priority == "Low"){
      box.style.backgroundColor = "yellow";
    }
    else {
      box.style.backgroundColor = "red";
    }
  }
}
