/**
 * 
 */

function checkpassword() {
	var pw1 = document.getElementById("password").value;
	var pw1 = document.getElementById("repassword").value;

	if (pw1 != pw2) {
		alert("password mismatcj");
		return false;
	} else {
		alert("password match");
		return true
	}

}