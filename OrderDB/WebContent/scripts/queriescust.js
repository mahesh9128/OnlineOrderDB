/**
 * 
 */


window.onload = function() {
	
	query5();
	query8();
	
	document.getElementById("querybtn1").onclick= function(){
		var area = document.getElementById("areaid");
		var cuisine = document.getElementById("cuisineid");
		var query1Json = {};
		query1Json["queryno"] = 1;
		query1Json["area"] = area.value;
		query1Json["cuisine"] = cuisine.value;
		var jsonStr = JSON.stringify(query1Json);
		//ajax call
		var xmlhttp;
		if (window.XMLHttpRequest)
			xmlhttp = new XMLHttpRequest();
		else
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
		xmlhttp.open("POST", "/OrderDB/queryDb", true);
		xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlhttp.send(jsonStr);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("query1").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	//query 2 
	document.getElementById("querybtn2").onclick= function(){
		var cuisine = document.getElementById("cuisineid2");
		var query2Json = {};
		query2Json["queryno"] = 2;
		query2Json["cuisine2"] = cuisine.value;
		var jsonStr = JSON.stringify(query2Json);
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
				document.getElementById("query2").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	//query 3
	document.getElementById("querybtn3").onclick= function(){
		var cuisine = document.getElementById("cuisineid3");
		var price = document.getElementById("price3");
		var query3Json = {};
		query3Json["queryno"] = 3;
		query3Json["cuisine3"] = cuisine.value;
		query3Json["price3"] = price.value;
		var jsonStr = JSON.stringify(query3Json);
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
				document.getElementById("query3").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	//query 4
	document.getElementById("querybtn4").onclick= function(){
		var combid = document.getElementById("comboid4");
		var name = document.getElementById("name4");
		var day = document.getElementById("day4");
		var query4json = {};
		query4json["queryno"] = 4;
		query4json["comboid4"] = combid.value;
		query4json["name4"] = name.value;
		query4json["day4"] = day.value;
		var jsonStr = JSON.stringify(query4json);
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
				document.getElementById("query4").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	//query 10
	document.getElementById("querybtn10").onclick= function(){
		var name = document.getElementById("name10");
		var query10json = {};
		query10json["queryno"] = 10;
		query10json["name10"] = name.value;
		var jsonStr = JSON.stringify(query10json);
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
				document.getElementById("query10").innerHTML =xmlhttp.responseText;
			}
		};
	};
	
	document.getElementById("logout").onclick= function(){
		window.location.href="../login.html";
	};
	
	
	
}

function query5(){

	var query5json = {};
	query5json["queryno"] = 5;
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
			document.getElementById("query5").innerHTML =xmlhttp.responseText;
		}
	};
}


function query8(){

	var query5json = {};
	query5json["queryno"] = 8;
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
			document.getElementById("query8").innerHTML =xmlhttp.responseText;
		}
	};
	
}


