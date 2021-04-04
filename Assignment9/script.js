"use strict";
var currEmployeeId = 1000;
var vehicleId = 100;
var Employee = /** @class */ (function () {
    function Employee(id, name, gender, email, contact_no, password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contact_no = contact_no;
        this.password = password;
    }
    return Employee;
}());
var EmployeeData = /** @class */ (function () {
    function EmployeeData() {
        this.EmployeeList = [];
    }
    EmployeeData.prototype.addEmployee = function (employee) {
        this.EmployeeList.push(employee);
    };
    return EmployeeData;
}());
var Feedback = /** @class */ (function () {
    function Feedback(date, email, subject, message) {
        this.date = date;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
    return Feedback;
}());
var FeedbackData = /** @class */ (function () {
    function FeedbackData() {
        this.FeedbackList = [];
    }
    FeedbackData.prototype.addFeedback = function (employee) {
        this.FeedbackList.push(employee);
    };
    return FeedbackData;
}());
var Vehicle = /** @class */ (function () {
    function Vehicle(vehicleCompany, vehicleModel, vehicleType, vehicleNo, identification, employeeId) {
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleNo = vehicleNo;
        this.identification = identification;
        this.employeeID = employeeId;
    }
    return Vehicle;
}());
var VehicleData = /** @class */ (function () {
    function VehicleData() {
        this.VehicleList = [];
    }
    VehicleData.prototype.addVehicle = function (employee) {
        this.VehicleList.push(employee);
    };
    return VehicleData;
}());
var VehiclePass = /** @class */ (function () {
    function VehiclePass(pass) {
        this.time = new Date();
        this.pass = pass;
    }
    return VehiclePass;
}());
var VehiclePassData = /** @class */ (function () {
    function VehiclePassData() {
        this.VehiclePassList = [];
    }
    VehiclePassData.prototype.addVehiclePass = function (employee) {
        this.VehiclePassList.push(employee);
    };
    return VehiclePassData;
}());
var isName = function (str) {
    // one or more lowercase and uppercase letter with .
    var re = /^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{2,}$/;
    return re.test(str);
};
var validateName = function (element) {
    if (isName(element.value)) {
        element.style.border = "2px solid green";
    }
    else {
        element.style.border = "2px solid red";
    }
};
var isEmail = function (str) {
    //mysite@ourearth.com
    var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(str);
};
var validateEmail = function (element) {
    if (isEmail(element.value)) {
        element.style.border = "2px solid green";
    }
    else {
        element.style.border = "2px solid red";
    }
};
var isContactNo = function (str) {
    // 8 numbers first non zero
    var re = /^[1-9]{1}[0-9]{7}$/;
    return re.test(str);
};
var validateContactNo = function (element) {
    if (isContactNo(element.value)) {
        element.style.border = "2px solid green";
    }
    else {
        element.style.border = "2px solid red";
    }
};
var isNormal = function (str) {
    // at least one number, one lowercase and one uppercase letter
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,}$/;
    return re.test(str);
};
var isStrong = function (str) {
    // at least one number, one lowercase and one uppercase letter and special character
    var re = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;
    return re.test(str);
};
var validatePassword = function (passwordText) {
    if (isStrong(passwordText.value)) {
        passwordText.style.border = "2px solid green";
    }
    else if (isNormal(passwordText.value)) {
        passwordText.style.border = "2px solid orange";
    }
    else {
        passwordText.style.border = "2px solid red";
    }
};
var passwordText = document.getElementById("password");
var confirmPasswordText = document.getElementById("confirmPassword");
var validateConfirmPassword = function () {
    if (passwordText.value == confirmPasswordText.value) {
        return true;
    }
    return false;
};
var confirmPass = function (confirmPas) {
    if (confirmPas.value != passwordText.value) {
        confirmPas.style.border = "2px solid red";
    }
    else {
        confirmPas.style.border = "2px solid green";
    }
};
var isVehicleNoOrModel = function (str) {
    // 8 numbers first non zero
    var re = new RegExp('^[1-9]{1}[0-9]{5}$');
    return re.test(str);
};
var validateVehicleNoOrModel = function (element) {
    if (isVehicleNoOrModel(element.value)) {
        element.style.border = "2px solid green";
    }
    else {
        element.style.border = "2px solid red";
    }
};
var isEmployeeId = function (id) {
    if (id > 999 && id < 5001) {
        return true;
    }
    return false;
};
var validateEmployeeId = function (element) {
    if (isEmployeeId(element.value)) {
        element.style.border = "2px solid green";
    }
    else {
        element.style.border = "2px solid red";
    }
};
var validateTextArea = function (element) {
    element.style.border = "2px solid green";
};
var findindex = function (element, elementArray) {
    for (var index = 0; index < elementArray.length; index++) {
        if (elementArray[index] == element) {
            return index;
        }
    }
    return -1;
};
var avarray = document.getElementsByClassName("av");
for (var index = 1; index < avarray.length; index++) {
    avarray[index].style.display = "none";
}
var validateAV = function (element) {
    if (element.name == "vehicleCompany") {
        return isName(element.value);
    }
    else if (element.name == "vehicleModel") {
        return isVehicleNoOrModel(element.value);
    }
    else if (element.name == "vehicleNumber") {
        return isVehicleNoOrModel(element.value);
    }
    else if (element.name == "employeeId") {
        return isEmployeeId(element.value);
    }
    else {
        return true;
    }
};
var nextAV = function (element, e) {
    if (e === void 0) { e = undefined; }
    console.log(element.parentElement, e);
    if ((e == undefined || e.keyCode == 13) && validateAV(element)) {
        if (e == undefined) {
            var index = findindex(element.parentElement.parentElement, avarray);
        }
        else {
            var index = findindex(element.parentElement, avarray);
        }
        avarray[index].style.display = "none";
        avarray[index + 1].style.display = "block";
    }
};
var aeArray = document.getElementsByClassName("ae");
for (var index = 1; index < aeArray.length; index++) {
    aeArray[index].style.display = "none";
}
var validateAE = function (element) {
    if (element.name == "fullname") {
        return isName(element.value);
    }
    else if (element.name == "employeeEmail") {
        return isEmail(element.value);
    }
    else if (element.name == "password") {
        return isStrong(element.value);
    }
    else if (element.name == "confirmPassword") {
        return validateConfirmPassword();
    }
    else if (element.name == "phone") {
        return isContactNo(element.value);
    }
    else {
        return true;
    }
};
var nextAE = function (element, e) {
    if (e === void 0) { e = undefined; }
    console.log(element.parentElement, e);
    if ((e == undefined || e.keyCode == 13) && validateAE(element)) {
        if (e == undefined) {
            var index = findindex(element.parentElement.parentElement, aeArray);
        }
        else {
            var index = findindex(element.parentElement, aeArray);
        }
        aeArray[index].style.display = "none";
        aeArray[index + 1].style.display = "block";
    }
};
var gfArray = document.getElementsByClassName("gf");
for (var index = 1; index < gfArray.length; index++) {
    gfArray[index].style.display = "none";
}
var validateGF = function (element) {
    if (element.name == "feedbackEmail") {
        return isEmail(element.value);
    }
    else {
        return true;
    }
};
var nextGF = function (element, e) {
    if (e.keyCode == 13 && validateGF(element)) {
        var index = findindex(element.parentElement, gfArray);
        gfArray[index].style.display = "none";
        gfArray[index + 1].style.display = "block";
    }
};
var pfArray = document.getElementsByClassName("pf");
for (var index = 1; index < pfArray.length; index++) {
    pfArray[index].style.display = "none";
}
var showPrice = function (element) {
    pfArray[0].style.display = "none";
    if (element.value == "cycle") {
        pfArray[1].style.display = "block";
    }
    else if (element.value == "motorCycle") {
        pfArray[2].style.display = "block";
    }
    else {
        pfArray[3].style.display = "block";
    }
    pfArray[4].style.display = "block";
    element.parentElement.parentElement.parentElement.style.maxHeight = "100%";
};
var employeeData = new EmployeeData();
var addEmployee = function () {
    var addEmployeeForm = document.getElementById("addEmployeeForm");
    var name = addEmployeeForm['fullName'].value;
    var genderElement = document.getElementsByName("gender");
    var gender = "notAssigned";
    ;
    for (var index = 0; index < genderElement.length; index++) {
        if (genderElement[index].checked) {
            gender = genderElement[index].value;
        }
    }
    var email = addEmployeeForm['employeeEmail'].value;
    var password = addEmployeeForm['password'].value;
    var contactNo = addEmployeeForm['phone'].value;
    employeeData.addEmployee(new Employee(currEmployeeId, name, gender, email, contactNo, password));
    currEmployeeId += 1;
    alert("employee Id : " + currEmployeeId);
};
var vehicleData = new VehicleData();
var addVehicle = function () {
    var addVehicleForm = document.getElementById("addVehicleForm");
    var vehicleModel = addVehicleForm['vehicleModel'].value;
    var vehicleCompany = addVehicleForm['vehicleCompany'].value;
    var typeElement = document.getElementsByName("vehicleType");
    var vehicleType = "notAssigned";
    for (var index = 0; index < typeElement.length; index++) {
        if (typeElement[index].checked) {
            vehicleType = typeElement[index].value;
        }
    }
    var vehicleNumber = addVehicleForm['vehicleNumber'].value;
    var employeeId = addVehicleForm['employeeId'].value;
    var identification = addVehicleForm['identification'].value;
    vehicleData.addVehicle(new Vehicle(vehicleCompany, vehicleModel, vehicleType, vehicleNumber, identification, employeeId));
    alert("Invalid Employee Id");
    vehicleId++;
};
var feedbacData = new FeedbackData();
var addFeedback = function () {
    var giveFeedbackForm = document.getElementById("giveFeedbackForm");
    var date = giveFeedbackForm['feedbackDate'].value;
    var email = giveFeedbackForm['feedbackEmail'].value;
    var subjectOfFeedback = giveFeedbackForm['subjectOfFeedback'].value;
    var feedbackMessage = giveFeedbackForm['feedbackMessage'].value;
    feedbacData.addFeedback(new Feedback(date, email, subjectOfFeedback, feedbackMessage));
    alert("feedback register");
};
var currencyConversion = {
    "DollarToINR": 74,
    "DollarToYen": 60
};
var priceList = {
    "cyclePricingPerDay": 5, "cyclePricingPerMonth": 100, "cyclePricingPerYear": 500,
    "motorCyclePricingPerDay": 10, "motorCyclePricingPerMonth": 200, "motorCyclePricingPerYear": 1000,
    "fourWheelerPricingPerDay": 20, "fourWheelerPricingPerMonth": 500, "fourWheelerPricingPerYear": 3500
};
var convertCurrency = function (element) {
    var currencyConverter = currencyConversion[element.value];
    var p1 = document.getElementById("p1");
    var p2 = document.getElementById("p2");
    var p3 = document.getElementById("p3");
    p1.innerHTML = "<p>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </p>";
    p2.innerHTML = "<p>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </p>";
    p3.innerHTML = "<p>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </p>";
    var p11 = document.getElementById("p11");
    var p12 = document.getElementById("p12");
    var p13 = document.getElementById("p13");
    p11.innerHTML = "<span>  #" + priceList["cyclePricingPerDay"] * currencyConverter + " Per Month </span>";
    p12.innerHTML = "<span>  #" + priceList["cyclePricingPerMonth"] * currencyConverter + " Per Month </span>";
    p13.innerHTML = "<span>  #" + priceList["cyclePricingPerYear"] * currencyConverter + " Per Month </span>";
    var p21 = document.getElementById("p21");
    var p22 = document.getElementById("p22");
    var p23 = document.getElementById("p23");
    p21.innerHTML = "<span>  #" + priceList["motorCyclePricingPerDay"] * currencyConverter + " Per Month </span>";
    p22.innerHTML = "<span>  #" + priceList["motorCyclePricingPerMonth"] * currencyConverter + " Per Month </span>";
    p23.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>";
    var p31 = document.getElementById("p31");
    var p32 = document.getElementById("p32");
    var p33 = document.getElementById("p33");
    p31.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerDay"] * currencyConverter + " Per Month </span>";
    p32.innerHTML = "<span>  #" + priceList["fourWheelerPricingPerMonth"] * currencyConverter + " Per Month </span>";
    p33.innerHTML = "<span>  #" + priceList["motorCyclePricingPerYear"] * currencyConverter + " Per Month </span>";
};
var vehiclePassData = new VehiclePassData();
var getPass = function () {
    var priceElement = document.getElementsByName("pricing");
    var priceDetail = "notAssigned";
    for (var index = 0; index < priceElement.length; index++) {
        if (priceElement[index].checked) {
            priceDetail = priceElement[index].value;
        }
    }
    vehiclePassData.addVehiclePass(new VehiclePass(priceDetail));
    alert(priceDetail);
};
