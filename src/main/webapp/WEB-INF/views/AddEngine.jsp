<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.engine.enginecomponent.dto.*" 
    import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Engine</title>
<link rel="stylesheet" href="css/form.css" />
</head>
<body>
<div id="div">
<h1>Enter engine details</h1><br><br>
<form>
  <p>
    <label for="1">Engine name:</label>
    <input id="1" type="text" name="engineName">
  </p>
  <br>
  <p>
    <label for="2">Type:</label>
    <select id="2" name="engineType">
     <option value="Petrol">Petrol</option>
     <option value="Diesel">Diesel</option>
    </select>
  </p>
  <br>
  <p>
    <label for="3">Displacement:</label>
    <input id="3" type="text" name="displacement">
  </p>
  <br>
  <p>
    <label for="4">Manufacturer:</label>
    <select id="4" name="engineManufacturer">
	   <% 
    	List<Manufacturer> manufactures = (List<Manufacturer>) request.getAttribute("engineManufactures");
		if(manufactures != null && manufactures.size() > 0){
			for(int i=0;i<manufactures.size();i++){
		%>
	    <option value="<%=manufactures.get(i).getManufacturerId()%>"><%=manufactures.get(i).getName()%></option>
	   <%}}%>
  	</select>
  </p>
  <br>
  <p>
    <input type="submit" value="Save" formaction="addengine" formmethod="post">&ensp;
	<input type="submit" value="Cancel" formaction="enginelist" formmethod="post">
  </p>
</form>
</div>
</body>
</html>