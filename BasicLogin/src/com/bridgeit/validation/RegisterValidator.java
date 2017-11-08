package com.bridgeit.validation;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RegisterValidator {
	private final String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
	
	public List<String> validate(String email, String password)
	{
		List<String> errorList = new ArrayList<String>();
		errorList.add(validateEmailId(email));
		errorList.add(password);
		return errorList;
	}
	

	public String validateEmailId(String email) {
		if (email != null) {
			if (email.equals("")) {
				return "Enter the email-ID";

			} else if (!Pattern.matches(emailRegex, email)) {
				return "Invalid Email-ID";

			} else
				return "sucess";
		} else {
			return "Enter the email-ID";

		}
	}

	public String validatePassword(String password) {
		if (password != null) {
			if (password.equals("")) {
				return "Password Cannot be Empty";

			} else if (password.length() <= 5) {
				return "Password must be greater than 4";

			} else
				return "sucess";
		} else {
			return "Password Cannot be Empty";

		}

	}

}
