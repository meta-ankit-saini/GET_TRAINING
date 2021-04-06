var currEmployeeId = 1000;
var vehicleId = 100;

function isName(str){
  // one or more lowercase and uppercase letter with .
  var re =/^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{2,}$/;
  return re.test(str);
}

function validateName(element){
  if(isName(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

function isEmail(str){
  //mysite@ourearth.com
  var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(str);
}

function validateEmail(element){
  if(isEmail(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

function isContactNo(str){
  // 8 numbers first non zero
  var re = /^[1-9]{1}[0-9]{7}$/;
  return re.test(str);
}

function validateContactNo(element)
{   
  if(isContactNo(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

function isNormal(str)
{   
  // at least one number, one lowercase and one uppercase letter
  var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/;
  return re.test(str);
}

function isStrong(str)
{   
  // at least one number, one lowercase and one uppercase letter and special character
  var re = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;
  return re.test(str);
}

function validatePassword(passwordText) {
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

passwordText =  document.getElementById("password");
confirmPasswordText =  document.getElementById("confirmPassword");
function validateConfirmPassword(){
  if (passwordText.value == confirmPasswordText.value) {
    return true;
  }
  return false;
}


function confirmPass(confirmPas) {
  if (confirmPas.value != passwordText.value) {
    confirmPas.style.border = "2px solid red";
  } 
  else {
    confirmPas.style.border = "2px solid green";
  }
}


function isVehicleNoOrModel(str){
  // 8 numbers first non zero
  var re = /^[1-9]{1}[0-9]{5}$/;
  return re.test(str);
}

function validateVehicleNoOrModel(element)
{   
  if(isVehicleNoOrModel(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

function isEmployeeId(id){
  if (id > 999 && id < 5001){
    return true;
  }
  return false;
}

function validateEmployeeId(element)
{   
  if(isEmployeeId(element.value)){
    element.style.border = "2px solid green";
  }
  else {
    element.style.border = "2px solid red";
  }
}

function validateTextArea(element)
{   
  element.style.border = "2px solid green";
}

function findindex(element , elementArray){
  for (var index = 0; index < elementArray.length ; index++){
    if (elementArray[index] == element){
        return index;
    }
  }
  return -1;
}

var avArray = document.getElementsByClassName("av");
for (var index = 1; index < avArray.length ; index++){
  avArray[index].style.display = "none";
}


function validateAV(element){
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


function nextAV(element , e = undefined){
  console.log(element.parentElement,e);
  if((e == undefined || e.keyCode == 13) && validateAV(element)){
    if (e == undefined){
      var index = findindex(element.parentElement.parentElement , avArray );
    }
    else {
      var index = findindex(element.parentElement , avArray );
    }
    avArray[index].style.display = "none";
    avArray[index + 1].style.display = "block";
  }
}

var aeArray = document.getElementsByClassName("ae");
for (var index = 1; index < aeArray.length ; index++){
  aeArray[index].style.display = "none";
}

function validateAE(element){
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

function nextAE(element , e = undefined){
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


var gfArray = document.getElementsByClassName("gf");
for (var index = 1; index < gfArray.length ; index++){
  gfArray[index].style.display = "none";
}

function validateGF(element){
  if (element.name == "feedbackEmail" ) {
    return isEmail(element.value);
  }
  else {
    return true;
  }
}

function nextGF(element , e){
  if(e.keyCode == 13 && validateGF(element)){
    var index = findindex(element.parentElement , gfArray );
    gfArray[index].style.display = "none";
    gfArray[index + 1].style.display = "block";
  }
}

var pfArray = document.getElementsByClassName("pf");
for (var index = 1; index < pfArray.length ; index++){
  pfArray[index].style.display = "none";
}

function showPrice(element){
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

function addEmployee() {
  var addEmployeeForm = document.getElementById("addEmployeeForm");
  var name = addEmployeeForm['fullName'].value;
  var genderElement = document.getElementsByName("gender");
  var gender = null;
  for(var i = 0; i < genderElement.length; i++){
    if(genderElement[i].checked){
        gender = genderElement[i].value;
    }
  }
  var email = addEmployeeForm['employeeEmail'].value;
  var password = addEmployeeForm['password'].value;
  var contactNo = addEmployeeForm['phone'].value;
  currEmployeeId += 1;
  alert( "employee Id : " +currEmployeeId);
  }

  function addVehicle() {
    var addVehicleForm = document.getElementById("addVehicleForm");
    var vehicleModel = addVehicleForm['vehicleModel'].value;
    var vehicleCompany = addVehicleForm['vehicleCompany'].value;
    var typeElement = document.getElementsByName("vehicleType");
    var vehicleType = null;
    for(var i = 0; i < typeElement.length; i++){
      if(typeElement[i].checked){
        vehicleType = typeElement[i].value;
      }
    }
    var vehicleNumber = addVehicleForm['vehicleNumber'].value;
    var employeeId = addVehicleForm['employeeId'].value;
    var identification = addVehicleForm['identification'].value;
    
    alert("Vehicle Id" + vehicleCompany);
    vehicleId++;
    }


  function  addFeedback(){
    var giveFeedbackForm = document.getElementById("giveFeedbackForm");

    var date =  giveFeedbackForm['feedbackDate'].value;
    var email = giveFeedbackForm['feedbackEmail'].value;
    var subjectOfFeedback = giveFeedbackForm['subjectOfFeedback'].value;
    var feedbackMessage = giveFeedbackForm['feedbackMessage'].value;
    alert("feedback register");
  }


  var currencyConversion = { "DollarToINR": 74, "DollarToYen": 60 };
  var priceList = { "cyclePricingPerDay": 5, "cyclePricingPerMonth": 100, "cyclePricingPerYear": 500 , 
  "motorCyclePricingPerDay": 10, "motorCyclePricingPerMonth": 200, "motorCyclePricingPerYear": 1000 , 
  "fourWheelerPricingPerDay": 20, "fourWheelerPricingPerMonth": 500, "fourWheelerPricingPerYear": 3500  };


function convertCurrency(element){
  currencyConverter = currencyConversion[element.value];
  var p1 = document.getElementById("p1");
  var p2 = document.getElementById("p2");
  var p3 = document.getElementById("p3");
  p1.innerHTML = "<p>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </p>"
  p2.innerHTML = "<p>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </p>"
  p3.innerHTML = "<p>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </p>"
  
  var p11 = document.getElementById("p11");
  var p12 = document.getElementById("p12");
  var p13 = document.getElementById("p13");
  p11.innerHTML = "<span>  #" + priceList["cyclePricingPerDay"] * currencyConverter + " Per Month </span>"
  p12.innerHTML = "<span>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </span>"
  p13.innerHTML = "<span>  #" + priceList["cyclePricingPerYear"] * currencyConverter + " Per Month </span>"

  var p21 = document.getElementById("p21");
  var p22 = document.getElementById("p22");
  var p23 = document.getElementById("p23");
  p21.innerHTML = "<span>  #" + priceList["motorCyclePricingPerDay"] * currencyConverter + " Per Month </span>"
  p22.innerHTML = "<span>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </span>"
  p23.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>"

  var p31 = document.getElementById("p31");
  var p32 = document.getElementById("p32");
  var p33 = document.getElementById("p33");
  p31.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerDay"] * currencyConverter + " Per Month </span>"
  p32.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </span>"
  p33.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>"
}

function  getPass(){
  var priceElement = document.getElementsByName("pricing");
  var priceDetail = null;
  for(var i = 0; i < priceElement.length; i++){
    if(priceElement[i].checked){
      priceDetail = priceElement[i].value;
    }
  }
  alert(priceDetail);
}




