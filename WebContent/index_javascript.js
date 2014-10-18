function show_user_option(choice, address) {
	document.getElementById("INTEXT").value = address;

	var str = choice;
	var arr = str.split(",");
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == "108") {
			document.getElementById("108").checked = true;
		} else if (arr[i] == "113") {
			document.getElementById("113").checked = true;
		} else if (arr[i] == "124") {
			document.getElementById("124").checked = true;
		} else if (arr[i] == "139") {
			document.getElementById("139").checked = true;
		} else if (arr[i] == "174") {
			document.getElementById("174").checked = true;
		} else {
			// document.getElementById("108").checked=true;
		}
	}
}

function hideloading() {
	// document.getElementById("LOADING").style.visibility = "hidden";
	document.getElementById("LOADING").style.display = "none";
}
function showloading() {
	// document.getElementById("LOADING").style.visibility = "visible";
	document.getElementById("LOADING").style.display = "block";
}

$(document).ready(function() {
	$("#FLIPBTN").click(function() {
		$("#Analysis").slideToggle("slow");
	});
});