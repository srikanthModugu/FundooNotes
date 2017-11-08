
function  display() {
    document.getElementById("message").style.display = "block";
}


function hide() {
    document.getElementById("message").style.display = "none";
}


function validation() {
	var pass = document.getElementById("psw");
	var letter = document.getElementById("letter");
	var capital = document.getElementById("capital");
	var number = document.getElementById("number");
	var length = document.getElementById("length");
    var  check = false; 
  var lowerCaseLetters = /[a-z]/g;
  if(pass.value.match(lowerCaseLetters)) {  
    letter.classList.remove("unchecked");
    letter.classList.add("checked");
    check = true;
  } else {
    letter.classList.remove("checked");
    letter.classList.add("unchecked");
    check = false;
  }
  

  var upperCaseLetters = /[A-Z]/g;
  if(pass.value.match(upperCaseLetters)) {  
    capital.classList.remove("unchecked");
    capital.classList.add("checked");
    check = true;
  } else {
    capital.classList.remove("checked");
    capital.classList.add("unchecked");
    check = false;
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(pass.value.match(numbers)) {  
    number.classList.remove("unchecked");
    number.classList.add("checked");
    check = true;
  } else {
    number.classList.remove("checked");
    number.classList.add("unchecked");
    check = false;
  }
  
  // Validate length
  if(pass.value.length >= 8) {
    length.classList.remove("unchecked");
    length.classList.add("checked");
    check = true;
  } else {
    length.classList.remove("checked");
    length.classList.add("unchecked");
    check = false;
  }
  if(check){
	  document.getElementById('pswMsg').style.color=' #008000';
  }
  else{
	  document.getElementById('pswMsg').style.color='#f44336'; 
  }
}

function emailValidation(){
	var email = document.getElementById("rEmail").value;
	if(email == null || email == ""){
		 document.getElementById("emailMsg").innerHTML = "Email is required";
		 document.getElementById('emailMsg').style.color='#f44336';
		 
	}
	else{
		var re = /[^\s@]+@[^\s@]+\.com+/;
		if(re.test(email)){
			document.getElementById("emailMsg").innerHTML = "Email";
			document.getElementById('emailMsg').style.color=' #008000';
		}
		else{
		document.getElementById("emailMsg").innerHTML = "Invalid Email";
		document.getElementById('emailMsg').style.color='#f44336';
		}
		}
}

function rePassWordValidation(){
	var pass = document.getElementById("psw").value;
	var rePass = document.getElementById("rePsw").value;
	if(pass == rePass){
		 document.getElementById("rePswMsg").innerHTML = "Repeat Password";
		 document.getElementById('rePswMsg').style.color= '#008000';
	}
	else{
		 document.getElementById("rePswMsg").innerHTML = "PassWord is not matching";
		 document.getElementById('rePswMsg').style.color= '#f44336';
		}
}

