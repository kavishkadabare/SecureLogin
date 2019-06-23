<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}
</style>
</head>
<body>

<div align= "center" style="width:100%">
<div align="center" style="width:40%">
<H1>Home </H1>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

/* $(document).on("submit", "#someform", function(event) {
    var $form = $(this);
    console.log("Ajax call!!!!!!!");
    $.post($form.attr("action"), $form.serialize(), function(response) {
    	 $("#somediv").text(response);
    	 $("#hidden").value(response);  
    	 console.log("Ajax Post ");
    	 console.log(response);
    }); */
    
    $(document).ready(function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
        $.get("WelcomeServlet", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
            $("#somediv").text(responseText); // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
        	$("#hidden").val(responseText);
            console.log(responseText);
        });

   
});
        </script>
        
        
<form action="WelcomeServlet" method="POST" id="someform">

<input name="token" type ="hidden" id="hidden"/>
<h4>Type something</h4><input type = "text"/>
<button type = "submit" name ="submit" id="submit">Submit </button>
<div name="divname"></div>
</form>
</div>
</div>
</body>
</html>