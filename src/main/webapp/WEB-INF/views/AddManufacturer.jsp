<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddManufacturer</title>
<link rel="stylesheet" href="css/form.css" />
</head>
<body>
<div id="div">
<h1>Enter manufacture details</h1><br><br>
<form>
  <p>
    <label for="1">Name:</label>
    <input id="1" type="text" name="name">
  </p>
  <br>
  <p>
    <label for="2">Address:</label>
    <textarea id="2" name="address" rows="3" ></textarea>
  </p>
  <br>
  <p>
    <label for="3">Contact Number:</label>
    <input id="3" type="text" name="contactNumber">
  </p>
  <br>
  <p>
    <input type="submit" value="Save" formaction="addmanufacturer" formmethod="post">&ensp;
	<input type="submit" value="Cancel" formaction="manufactureslist" formmethod="post">
  </p>
</form>
</div>
</body>
</html>