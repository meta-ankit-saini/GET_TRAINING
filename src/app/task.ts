export class Task{
    creationDate : Date;
    completionDate : string;
    title : string;
    description : string
    status : string;
    priority : string;


    constructor(title : string , description : string ,status : string  ,priority : string, completionDate : string){
        this.creationDate = new Date();
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.completionDate = completionDate
    }
    setStatus(status : string){
        this.status = status;
    }
    setTitle(title : string){
        this.title = title;
    }
    setCompletionDate(completionDate : string){
        this.completionDate = completionDate;
    }
    setPriority(priority : string){
        this.priority = priority;
    }
    getTitle(){
        return this.title;
    }
}