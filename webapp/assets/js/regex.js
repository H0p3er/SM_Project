	function validForm() {
		var isPassValid = equalsPass();
		var isPassRegexValid = passwordRegex();
		var isTelValid = validPhone();
        return isPassValid && isPassRegexValid && isTelValid;
	}

	function equalsPass() {
		var password = document.getElementById("password").value;
		var cfPassword = document.getElementById("retypepassword").value;
		if (password != cfPassword) {
			document.getElementById("passwordError").style.display = "block";
			return false;
		} else {
			document.getElementById("passwordError").style.display = "none";
			return true;
		}
	}

	function passwordRegex() {
		var password = document.getElementById("password").value;
		var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
		if (!regex.test(password)) {
			document.getElementById("regexError").style.display = "block";
			return false;
		} else {
			document.getElementById("regexError").style.display = "none";
			return true;
		}
	}
	function validPhone() {
		var phone = document.getElementById("phone").value;
		var regex = /^\d{10}$/;
		if (!regex.test(phone)) {
			document.getElementById("telRegexError").style.display = "block";
			return false;
		} else {
			document.getElementById("telRegexError").style.display = "none";
			return true;
		}
	}