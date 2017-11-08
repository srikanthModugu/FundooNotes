/**
 * 
 */
function emptyEmailValidation() {
	
    var x = document.getElementById("lEmail").value;
    if(x == null || x ==""){
    document.getElementById("EmailMsg").innerHTML = "Please enter Email..";
    document.getElementById('lEmail').style.borderColor='#FF0000';
    }
    else {
    	 document.getElementById("EmailMsg").innerHTML = "";
	}
       
}

function changeColor() {
	   
    document.getElementById('lEmail').style.borderColor='#0000FF';
    }

function emptyPassValidation(){
	var x = document.getElementById("lPassWord").value;
    if(x == null || x ==""){
    document.getElementById("PassMsg").innerHTML = "Please enter PassWord..";
    }
    else{
    	document.getElementById("PassMsg").innerHTML = "";
    	}
}

function validation(){
	   var email = document.forms["loginForm"]["lEmail"].value;
	   var pass = document.forms["loginForm"]["lPassWord"].value;
	    if (email == "" || pass == "") {
	    	
	   email == ""?document.getElementById("EmailMsg").innerHTML = "please Enter Email..":document.getElementById("EmailMsg").innerHTML = "";
	   pass == ""?document.getElementById("PassMsg").innerHTML = "Please enter PassWord..":document.getElementById("PassMsg").innerHTML = "";
	    	return false;
	    }
	    else{
	    	document.getElementById("EmailMsg").innerHTML = "";
	    	document.getElementById("PassMsg").innerHTML = "";
	        return true;
	    	}
}
