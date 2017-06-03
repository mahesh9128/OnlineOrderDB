/**
 * 
 */


window.onload = function() {

	
	//query 6
	document.getElementById("querybtn6").onclick= function(){
		var orderno = document.getElementById("order6");
		var query6json = {};
		query6json["queryno"] = 6;
		query6json["order6"] = orderno.value;
		var jsonStr = JSON.stringify(query6json);
		//ajax call
		var xmlhttp;
		if (window.XMLHttpRequest)
			xmlhttp = new XMLHttpRequest(); 
		else
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlhttp.open("POST", "/OrderDB/queryDb", true);
		xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlhttp.send(jsonStr);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("query6").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	//query 9
	document.getElementById("querybtn9").onclick= function(){
		var addr = document.getElementById("addr9");
		var query9json = {};
		query9json["queryno"] = 9;
		query9json["addr9"] = addr.value;
		var jsonStr = JSON.stringify(query9json);
		//ajax call
		var xmlhttp;
		if (window.XMLHttpRequest)
			xmlhttp = new XMLHttpRequest(); 
		else
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlhttp.open("POST", "/OrderDB/queryDb", true);
		xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlhttp.send(jsonStr);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("query9").innerHTML =xmlhttp.responseText;
			}
		};
	};

	//query 11
	document.getElementById("querybtn11").onclick= function(){
		var order = document.getElementById("order11");
		var query11json = {};
		query11json["queryno"] = 11;
		query11json["order11"] = order.value;
		var jsonStr = JSON.stringify(query11json);
		//ajax call
		var xmlhttp;
		if (window.XMLHttpRequest)
			xmlhttp = new XMLHttpRequest(); 
		else
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlhttp.open("POST", "/OrderDB/queryDb", true);
		xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlhttp.send(jsonStr);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("query11").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	query7();	
	
	document.getElementById("logout").onclick= function(){
		window.location.href="../login.html";
	};


}


function query7(){

	var query5json = {};
	query5json["queryno"] = 7;
	var jsonStr = JSON.stringify(query5json);
	//ajax call
	var xmlhttp;
	if (window.XMLHttpRequest)
		xmlhttp = new XMLHttpRequest(); 
	else
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlhttp.open("POST", "/OrderDB/queryDb", true);
	xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xmlhttp.send(jsonStr);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("query7").innerHTML =xmlhttp.responseText;
		}
	};
}



