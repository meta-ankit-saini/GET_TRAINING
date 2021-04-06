let currEmployeeId = 1000;
let vehicleId = 100;

const isName = (str) => {
  // one or more lowercase and uppercase letter with .
  const re =/^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{2,}$/;
  return re.test(str);
}

const validateName = (element) => {
  if(isName(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isEmail = (str) => {
  //mysite@ourearth.com
  const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(str);
}

const validateEmail = (element) => {
  if(isEmail(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isContactNo = (str) => {
  // 8 numbers first non zero
  const re = /^[1-9]{1}[0-9]{7}$/;
  return re.test(str);
}

const validateContactNo = (element) =>{   
  if(isContactNo(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isNormal = (str) =>{   
  // at least one number, one lowercase and one uppercase letter
  const re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/;
  return re.test(str);
}

const isStrong = (str) => {   
  // at least one number, one lowercase and one uppercase letter and special character
  const re = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;
  return re.test(str);
}

const validatePassword = (passwordText) => {
  if (isStrong(passwordText.value)) {
    passwordText.style.border = "2px solid green";
    password = passwordText.value;
  }
  else if (isNormal(passwordText.value)) {
    passwordText.style.border = "2px solid orange";
  } 
  else {
    passwordText.style.border = "2px solid red";
  }
}

let passwordText =  document.getElementById("password");
let confirmPasswordText =  document.getElementById("confirmPassword");
let validateConfirmPassword = () => {
  if (passwordText.value == confirmPasswordText.value) {
    return true;
  }
  return false;
}


const confirmPass = (confirmPas) => {
  if (confirmPas.value != passwordText.value) {
    confirmPas.style.border = "2px solid red";
  } 
  else {
    confirmPas.style.border = "2px solid green";
  }
}


const isVehicleNoOrModel = (str) => {
  // 8 numbers first non zero
  const re = /^[1-9]{1}[0-9]{5}$/;
  return re.test(str);
}

const validateVehicleNoOrModel = (element) => {   
  if(isVehicleNoOrModel(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const isEmployeeId = (id) => {
  if (id > 999 && id < 5001){
    return true;
  }
  return false;
}

const validateEmployeeId = (element) => {   
  if(isEmployeeId(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

const validateTextArea = (element) => {   
  element.style.border = "2px solid green";
}

const findindex = (element , elementArray) => {
  for (let index = 0; index < elementArray.length ; index++){
    if (elementArray[index] == element){
        return index;
    }
  }
  return -1;
}

let avarray = document.getElementsByClassName("av");
for (let index = 1; index < avarray.length ; index++){
  avarray[index].style.display = "none";
}


const validateAV = (element) => {
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


const nextAV = (element , e = undefined) => {
  console.log(element.parentElement,e);
  if((e == undefined || e.keyCode == 13) && validateAV(element)){
    if (e == undefined){
      var index = findindex(element.parentElement.parentElement , avarray );
    }
    else {
      var index = findindex(element.parentElement , avarray );
    }
    avarray[index].style.display = "none";
    avarray[index + 1].style.display = "block";
  }
}

let aeArray = document.getElementsByClassName("ae");
for (let index = 1; index < aeArray.length ; index++){
  aeArray[index].style.display = "none";
}

const validateAE = (element) => {
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

const nextAE = (element , e = undefined) => {
  console.log(element.parentElement,e);
  if((e == undefined || e.keyCode == 13) && validateAE(element) ){
    if (e == undefined){
      var index = findindex(element.parentElement.parentElement , aeArray );
    }
    else {
      var index = findindex(element.parentElement , aeArray );
    }
    aeArray[index].style.display = "none";
    aeArray[index + 1].style.display = "block";
  }
}


let gfArray = document.getElementsByClassName("gf");
for (let index = 1; index < gfArray.length ; index++){
  gfArray[index].style.display = "none";
}

const validateGF = (element) => {
  if (element.name == "feedbackEmail" ) {
    return isEmail(element.value);
  }
  else {
    return true;
  }
}

const nextGF = (element , e) => {
  if(e.keyCode == 13 && validateGF(element)){
    const index = findindex(element.parentElement , gfArray );
    gfArray[index].style.display = "none";
    gfArray[index + 1].style.display = "block";
  }
}

let pfArray = document.getElementsByClassName("pf");
for (let index = 1; index < pfArray.length ; index++){
  pfArray[index].style.display = "none";
}

const showPrice = (element) => {
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

const addEmployee = () => {
  const addEmployeeForm = document.getElementById("addEmployeeForm");
  const name = addEmployeeForm['fullName'].value;
  const genderElement = document.getElementsByName("gender");
  let gender = null;
  for(let i = 0; i < genderElement.length; i++){
    if(genderElement[i].checked){
        gender = genderElement[i].value;
    }
  }
  const email = addEmployeeForm['employeeEmail'].value;
  const password = addEmployeeForm['password'].value;
  const contactNo = addEmployeeForm['phone'].value;
  currEmployeeId += 1;
  alert("Vehicle Id" + vehicleCompany);
  }

const addVehicle = () => {
  const addVehicleForm = document.getElementById("addVehicleForm");
  const vehicleModel = addVehicleForm['vehicleModel'].value;
  const vehicleCompany = addVehicleForm['vehicleCompany'].value;
  const typeElement = document.getElementsByName("vehicleType");
  let vehicleType = null;
  for(let i = 0; i < typeElement.length; i++){
    if(typeElement[i].checked){
    vehicleType = typeElement[i].value;
    }
  }
  const vehicleNumber = addVehicleForm['vehicleNumber'].value;
  const employeeId = addVehicleForm['employeeId'].value;
  const identification = addVehicleForm['identification'].value;

  alert("Employee Id" + employeeId);
  vehicleId++;
}


const addFeedback = () => {
  const giveFeedbackForm = document.getElementById("giveFeedbackForm");
  
  const date =  giveFeedbackForm['feedbackDate'].value;
  const email = giveFeedbackForm['feedbackEmail'].value;
  const subjectOfFeedback = giveFeedbackForm['subjectOfFeedback'].value;
  const feedbackMessage = giveFeedbackForm['feedbackMessage'].value;
  alert("feedback register");
}


const currencyConversion = { "DollarToINR": 74, "DollarToYen": 60 };
const priceList = { "cyclePricingPerDay": 5, "cyclePricingPerMonth": 100, "cyclePricingPerYear": 500 , 
    "motorCyclePricingPerDay": 10, "motorCyclePricingPerMonth": 200, "motorCyclePricingPerYear": 1000 , 
    "fourWheelerPricingPerDay": 20, "fourWheelerPricingPerMonth": 500, "fourWheelerPricingPerYear": 3500  };


const convertCurrency = (element) => {
  currencyConverter = currencyConversion[element.value];
  let p1 = document.getElementById("p1");
  let p2 = document.getElementById("p2");
  let p3 = document.getElementById("p3");
  p1.innerHTML = "<p>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </p>"
  p2.innerHTML = "<p>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </p>"
  p3.innerHTML = "<p>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </p>"

  let p11 = document.getElementById("p11");
  let p12 = document.getElementById("p12");
  let p13 = document.getElementById("p13");
  p11.innerHTML = "<span>  #" + priceList["cyclePricingPerDay"] * currencyConverter + " Per Month </span>"
  p12.innerHTML = "<span>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </span>"
  p13.innerHTML = "<span>  #" + priceList["cyclePricingPerYear"] * currencyConverter + " Per Month </span>"

  let p21 = document.getElementById("p21");
  let p22 = document.getElementById("p22");
  let p23 = document.getElementById("p23");
  p21.innerHTML = "<span>  #" + priceList["motorCyclePricingPerDay"] * currencyConverter + " Per Month </span>"
  p22.innerHTML = "<span>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </span>"
  p23.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>"

  let p31 = document.getElementById("p31");
  let p32 = document.getElementById("p32");
  let p33 = document.getElementById("p33");
  p31.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerDay"] * currencyConverter + " Per Month </span>"
  p32.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </span>"
  p33.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>"
}

const  getPass = () => {
  const priceElement = document.getElementsByName("pricing");
  let priceDetail = null;
  for(let i = 0; i < priceElement.length; i++){
    if(priceElement[i].checked){
      priceDetail = priceElement[i].value;
    }
  }
  alert(priceDetail);
}




