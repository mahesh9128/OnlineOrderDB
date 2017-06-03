window.onload = function() {

	document.getElementById("loginbtn").onclick = function(){
		var userid = document.getElementById("userid");
		var pwd = document.getElementById("password");
		var loginJson = {};
		loginJson["userid"] = userid.value;
		loginJson["pwd"] = pwd.value;
		var jsonStr = JSON.stringify(loginJson);
		//ajax call
		var xmlhttp;
		if (window.XMLHttpRequest)
			xmlhttp = new XMLHttpRequest();
		else
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
		xmlhttp.open("POST", "/OrderDB/loginDb", true);
		xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlhttp.send(jsonStr);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if(xmlhttp.responseText=="admin"){
					window.location.href="./htmlPages/admin.html";
				}else if(xmlhttp.responseText=="cust"){
					window.location.href="./htmlPages/customer.html";
				}else{
					alert("invalid user name or password!!");
				}
				//document.getElementById("query1").innerHTML = xmlhttp.responseText;
			}
		};
	};


}