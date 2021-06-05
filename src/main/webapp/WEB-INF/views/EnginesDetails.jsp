<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.engine.enginecomponent.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Engine Details</title>
<link rel="stylesheet" href="css/detail.css" />
</head>
<body>
<% 
	Engine engine = (Engine) request.getAttribute("engine");
	Manufacturer engineManufacturer = new Manufacturer();
	if(engine == null){
		engine = new Engine();
		engine.setEngineManufacturer(engineManufacturer);
	}
	if(engine != null && engine.getEngineManufacturer() == null){
		engine.setEngineManufacturer(new Manufacturer());
	}
	engineManufacturer = engine.getEngineManufacturer();
	
%>
<h1>Engine <%=(String) request.getAttribute("h1")%></h1>
<form>
  <p>
    <b>Name: </b>
    <span><%=engine.getEngineName() %></span>
  </p>
  <p>
   	<b>Type: </b>
    <span><%=engine.getEngineType() %></span>
  </p>
  <p>
    <b>Displacement: </b>
    <span><%=engine.getDisplacement() %></span>
  </p><br>
</form>
<h2>Engine manufacture information</h2>
<form>
	<p>
    <b>Manufacture: </b>
    <span><%=engineManufacturer.getName() %></span>
  	</p>
  	<p>
   	<b>Address: </b>
    <span><%=engineManufacturer.getAddress() %></span>
	</p> 
	<p>
   	<b>Contact Number: </b>
    <span><%=engineManufacturer.getContactNumber() %></span>
	</p>   
  <br><br><br>
  <p>
    <input type="submit" value="Engines" formaction="enginelist" formmethod="post">&ensp;
	<input type="submit" value="Home" formaction="cars" formmethod="post">
  </p>
</form>
</body>
</html>