<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.engine.enginecomponent.dto.*" 
    import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddCar</title>
<link rel="stylesheet" href="css/form.css" />
</head>
<body>
<div id="div">
<h1>Enter car details</h1><br><br>
<form>
  <p>
    <label for="1">Manufacture:</label>
    <select id="1" name="manufacturer">
    	<% 
    	List<Manufacturer> manufactures = (List<Manufacturer>) request.getAttribute("manufactures");
		if(manufactures != null && manufactures.size() > 0){
			for(int i=0;i<manufactures.size();i++){
		%>
	    <option value="<%=manufactures.get(i).getManufacturerId()%>"><%=manufactures.get(i).getName()%></option>
	   <%}}%>
  	</select>
  </p>
  <br>
  <p>
    <label for="2">Model:</label>
    <input id="2" type="text" name="model">
  </p>
  <br>
  <p>
    <label for="3">Color:</label>
    <input id="3" type="text" name="color">
  </p>
  <br>
  <p>
    <label for="4">Engine:</label>
    <select id="4" name="engine">
	    <% 
    	List<Engine> engines = (List<Engine>) request.getAttribute("engines");
		if(engines != null && engines.size() > 0){
			for(int i=0;i<engines.size();i++){
		%>
	    <option value="<%=engines.get(i).getEngineId()%>"><%=engines.get(i).getEngineName()%></option>
	   <%}}%>
  	</select>
  </p>
  <br>
  <p>
    <label for="5">Price:</label>
    <input id="5" type="text" name="price">
  </p>
  <br>
  <p>
    <input type="submit" value="Save" formaction="addcar" formmethod="post">&ensp;
	<input type="submit" value="Cancel" formaction="cars" formmethod="post">
  </p>
</form>
</div>
</body>
</html>