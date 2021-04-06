export {}
let currEmployeeId : number= 1000;
let vehicleId : number = 100;

class Employee {
  private id: Number;
  private name: String;
  private gender: String;
  private email: String;
  private contact_no: String;
  private password: String;

  public constructor(id: Number, name: String, gender: String, email: String, contact_no: String, password: String) {
      this.id = id;
      this.name = name;
      this.gender = gender;
      this.email = email;
      this.contact_no = contact_no;
      this.password = password;
  }
}

class EmployeeData {
  private EmployeeList : Employee[];
  public constructor(){
    this.EmployeeList = [];
  }

  public addEmployee(employee  : Employee){
    this.EmployeeList.push(employee);
  }
}

class Feedback {
  private date: Date;
  private email: String;
  private subject: String;
  private message: String;
 
  public constructor(date: Date, email: String, subject: String, message: String) {
      this.date = date;
      this.email = email;
      this.subject = subject;
      this.message = message;
  }
}

class FeedbackData {
  private FeedbackList : Feedback[];
  public constructor(){
    this.FeedbackList = [];
  }

  public addFeedback(employee  : Feedback){
    this.FeedbackList.push(employee);
  }
}

class Vehicle {
  private  vehicleCompany: String;
  private  vehicleModel: String;
  private  vehicleType: String;
  private  vehicleNo: String;
  private  identification: String;
  private employeeID : number;

  public constructor(vehicleCompany: String, vehicleModel: String, vehicleType: String, vehicleNo: String, identification: String, employeeId: number) {
      this.vehicleCompany = vehicleCompany;
      this.vehicleModel = vehicleModel;
      this.vehicleType = vehicleType;
      this.vehicleNo = vehicleNo;
      this.identification = identification;
      this.employeeID = employeeId
  }
}

class VehicleData {
  private VehicleList : Vehicle[];
  public constructor(){
    this.VehicleList = [];
  }

  public addVehicle(employee  : Vehicle){
    this.VehicleList.push(employee);
  }
}

class VehiclePass {
  private time: Date;
  private  pass: String;
  

  public constructor( pass: String) {
      this.time = new Date();
      this.pass = pass;
  }
}

class VehiclePassData {
  private VehiclePassList : VehiclePass[];
  public constructor(){
    this.VehiclePassList = [];
  }

  public addVehiclePass(employee  : VehiclePass){
    this.VehiclePassList.push(employee);
  }
}

const isName : any = (str : string) : boolean => {
  // one or more lowercase and uppercase letter with .
  let re : RegExp  = /^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{2,}$/;
  return re.test(str);
}

const validateName : any = (element : any) : void => {
  if(isName(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isEmail : any = (str : string) : boolean => {
  //mysite@ourearth.com
  const re : RegExp = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(str);
}

const validateEmail : any = (element : any) : void => {
  if(isEmail(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isContactNo : any = (str : string) : boolean => {
  // 8 numbers first non zero
  const re : RegExp = /^[1-9]{1}[0-9]{7}$/;
  return re.test(str);
}

const validateContactNo : any = (element : any): void =>{   
  if(isContactNo(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isNormal : any = (str : string) : boolean =>{   
  // at least one number, one lowercase and one uppercase letter
  const re:RegExp = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/;
  return re.test(str);
}

const isStrong : any = (str : string) : boolean => {   
  // at least one number, one lowercase and one uppercase letter and special character
  const re : RegExp =  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;
  return re.test(str);
}

const validatePassword : any = (passwordText : any) : void => {
  if (isStrong(passwordText.value)) {
    passwordText.style.border = "2px solid green";
  }
  else if (isNormal(passwordText.value)) {
    passwordText.style.border = "2px solid orange";
  } 
  else {
    passwordText.style.border = "2px solid red";
  }
}

let passwordText : any =  document.getElementById("password");
let confirmPasswordText : any =  document.getElementById("confirmPassword");
const validateConfirmPassword : any = () : boolean => {
  if (passwordText.value == confirmPasswordText.value) {
    return true;
  }
  return false;
}


const confirmPass : any = (confirmPas : any) : void => {
  if (confirmPas.value != passwordText.value) {
    confirmPas.style.border = "2px solid red";
  } 
  else {
    confirmPas.style.border = "2px solid green";
  }
}


const isVehicleNoOrModel : any = (str : string) : boolean => {
  // 8 numbers first non zero
  const re : RegExp = new RegExp('^[1-9]{1}[0-9]{5}$');
  return re.test(str);
}

const validateVehicleNoOrModel : any = (element : any) : void => {   
  if(isVehicleNoOrModel(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isEmployeeId : any = (id : number) : boolean => {
  if (id > 999 && id < 5001){
    return true;
  }
  return false;
}

const validateEmployeeId : any = (element:any)  => {   
  if(isEmployeeId(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const validateTextArea : any = (element : any) => {   
  element.style.border = "2px solid green";
}

const findindex : any = (element : any , elementArray : any) : number => {
  for (let index : number = 0; index < elementArray.length ; index++){
    if (elementArray[index] == element){
        return index;
    }
  }
  return -1;
}

let avarray : any = document.getElementsByClassName("av");
for (let index : number = 1; index < avarray.length ; index++){
  avarray[index].style.display = "none";
}


const validateAV : any = (element : any) : boolean => {
  if (element.name == "vehicleCompany" ) {
    return isName(element.value);
  }
  else if(element.name == "vehicleModel" ) {
    return isVehicleNoOrModel(element.value);
  }
  else if (element.name == "vehicleNumber" ) {
    return isVehicleNoOrModel(element.value);
  }
  else if(element.name == "employeeId" ) {
    return isEmployeeId(element.value);
  }
  else {
    return true;
  }
}


const nextAV = (element : any , e : any = undefined) : void => {
  console.log(element.parentElement,e);
  if((e == undefined || e.keyCode == 13) && validateAV(element)){
    if (e == undefined){
      var index : number = findindex(element.parentElement.parentElement , avarray );
    }
    else {
      var index : number = findindex(element.parentElement , avarray );
    }
    avarray[index].style.display = "none";
    avarray[index + 1].style.display = "block";
  }
}

const aeArray : any = document.getElementsByClassName("ae");
for (let index : number = 1; index < aeArray.length ; index++){
  aeArray[index].style.display = "none";
}

const validateAE : any = (element : any) : boolean => {
  if (element.name == "fullname" ) {
    return isName(element.value);
  }
  else if(element.name == "employeeEmail" ) {
    return isEmail(element.value);
  }
  else if (element.name == "password" ) {
    return isStrong(element.value);
  }
  else if(element.name == "confirmPassword" ) {
    return validateConfirmPassword();
  }
  else if(element.name == "phone" ) {
    return isContactNo(element.value);
  }
  else {
    return true;
  }
}

const nextAE : any = (element : any , e : any = undefined) : void => {
  console.log(element.parentElement,e);
  if((e == undefined || e.keyCode == 13) && validateAE(element) ){
    if (e == undefined){
      var index : number = findindex(element.parentElement.parentElement , aeArray );
    }
    else {
      var index : number = findindex(element.parentElement , aeArray );
    }
    aeArray[index].style.display = "none";
    aeArray[index + 1].style.display = "block";
  }
}


let gfArray : any = document.getElementsByClassName("gf");
for (let index : number = 1; index < gfArray.length ; index++){
  gfArray[index].style.display = "none";
}

const validateGF : any = (element : any) : boolean => {
  if (element.name == "feedbackEmail" ) {
    return isEmail(element.value);
  }
  else {
    return true;
  }
}

const nextGF : any = (element : any , e : any) : void => {
  if(e.keyCode == 13 && validateGF(element)){
    const index : number = findindex(element.parentElement , gfArray );
    gfArray[index].style.display = "none";
    gfArray[index + 1].style.display = "block";
  }
}

let pfArray : any = document.getElementsByClassName("pf");
for (let index : number = 1; index < pfArray.length ; index++){
  pfArray[index].style.display = "none";
}

const showPrice : any = (element : any) : void => {
  pfArray[0].style.display = "none";  
  if (element.value == "cycle"){
    pfArray[1].style.display = "block";
  }
  else if (element.value == "motorCycle"){
    pfArray[2].style.display = "block";
  }
  else {
    pfArray[3].style.display = "block";
  }
  pfArray[4].style.display = "block";
  element.parentElement.parentElement.parentElement.style.maxHeight = "100%";
}

let employeeData : EmployeeData = new EmployeeData();

const addEmployee : any = () : void => {
  const addEmployeeForm : any = document.getElementById("addEmployeeForm");
  const name : string = addEmployeeForm['fullName'].value;
  const genderElement : any = document.getElementsByName("gender");
  let gender : string = "notAssigned";;
  for(let index = 0; index < genderElement.length; index++){
    if(genderElement[index].checked){
        gender = genderElement[index].value;
    }
  }
  const email : string = addEmployeeForm['employeeEmail'].value;
  const password : string = addEmployeeForm['password'].value;
  const contactNo : string = addEmployeeForm['phone'].value;
  employeeData.addEmployee(new Employee(currEmployeeId , name , gender , email , contactNo , password));
  currEmployeeId += 1;
  alert( "employee Id : " +currEmployeeId);
}

let vehicleData : VehicleData = new VehicleData();

const addVehicle : any = () : void => {
  const addVehicleForm : any = document.getElementById("addVehicleForm");
  const vehicleModel : string = addVehicleForm['vehicleModel'].value;
  const vehicleCompany : string = addVehicleForm['vehicleCompany'].value;
  const typeElement : any = document.getElementsByName("vehicleType");
  let vehicleType : string = "notAssigned";
  for(let index : number = 0; index < typeElement.length; index++){
    if(typeElement[index].checked){
    vehicleType = typeElement[index].value;
    }
  }
  const vehicleNumber : string = addVehicleForm['vehicleNumber'].value;
  const employeeId : number  = addVehicleForm['employeeId'].value;
  const identification : string = addVehicleForm['identification'].value;
  vehicleData.addVehicle(new Vehicle(vehicleCompany , vehicleModel , vehicleType, vehicleNumber
    , identification , employeeId));
  alert("Vehicle Id" + vehicleId);
  vehicleId++;
}

let feedbacData : FeedbackData = new FeedbackData();

const addFeedback : any = () : void => {
  const giveFeedbackForm : any = document.getElementById("giveFeedbackForm");
  const date : Date =  giveFeedbackForm['feedbackDate'].value;
  const email : string = giveFeedbackForm['feedbackEmail'].value;
  const subjectOfFeedback : string = giveFeedbackForm['subjectOfFeedback'].value;
  const feedbackMessage : string = giveFeedbackForm['feedbackMessage'].value;
  feedbacData.addFeedback(new Feedback(date, email , subjectOfFeedback , feedbackMessage));
  alert("feedback register");
}


const currencyConversion : any   = {
	"DollarToINR": 74,
	"DollarToYen": 60
};
const priceList : any = { 
  "cyclePricingPerDay": 5, "cyclePricingPerMonth": 100, "cyclePricingPerYear": 500 , 
  "motorCyclePricingPerDay": 10, "motorCyclePricingPerMonth": 200, "motorCyclePricingPerYear": 1000 , 
  "fourWheelerPricingPerDay": 20, "fourWheelerPricingPerMonth": 500, "fourWheelerPricingPerYear": 3500  };

const convertCurrency = (element : any) : void => {
  let currencyConverter = currencyConversion[element.value];
  let p1 : any = document.getElementById("p1");
  let p2 : any = document.getElementById("p2");
  let p3 : any = document.getElementById("p3");
  p1.innerHTML = "<p>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </p>"
  p2.innerHTML = "<p>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </p>"
  p3.innerHTML = "<p>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </p>"

  let p11 : any = document.getElementById("p11");
  let p12 : any = document.getElementById("p12");
  let p13 : any = document.getElementById("p13");
  p11.innerHTML = "<span>  #" + priceList["cyclePricingPerDay"] * currencyConverter + " Per Month </span>"
  p12.innerHTML = "<span>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </span>"
  p13.innerHTML = "<span>  #" + priceList["cyclePricingPerYear"] * currencyConverter + " Per Month </span>"

  let p21 : any = document.getElementById("p21");
  let p22 : any = document.getElementById("p22");
  let p23 : any = document.getElementById("p23");
  p21.innerHTML = "<span>  #" + priceList["motorCyclePricingPerDay"] * currencyConverter + " Per Month </span>"
  p22.innerHTML = "<span>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </span>"
  p23.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>"

  let p31 : any = document.getElementById("p31");
  let p32 : any = document.getElementById("p32");
  let p33 : any = document.getElementById("p33");
  p31.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerDay"] * currencyConverter + " Per Month </span>"
  p32.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </span>"
  p33.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>"
}

let vehiclePassData : VehiclePassData = new VehiclePassData();

const  getPass : any = () : void => {
  const priceElement : any = document.getElementsByName("pricing");
  let priceDetail : string  = "notAssigned";
  for(let index : number = 0; index < priceElement.length; index++){
    if(priceElement[index].checked){
      priceDetail = priceElement[index].value;
    }
  }
  vehiclePassData.addVehiclePass(new VehiclePass(priceDetail));
  alert(priceDetail);
}




