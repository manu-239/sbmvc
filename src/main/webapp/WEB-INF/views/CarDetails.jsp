<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.engine.enginecomponent.dto.*" 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Details</title>
<link rel="stylesheet" href="css/detail.css" />
</head>
<body>
<% 
	Car car = (Car) request.getAttribute("car");
	Engine engine = new Engine();
	Manufacturer carManufacturer = new Manufacturer();
	Manufacturer engineManufacturer = new Manufacturer();
	
	if(car == null){
		car = new Car();
		engine.setEngineManufacturer(engineManufacturer);
		car.setEngine(engine);
		car.setManufacturer(carManufacturer);
	}
	
	if(car != null && car.getEngine() == null){
		engine.setEngineManufacturer(engineManufacturer);
		car.setEngine(engine);
	}
	if(car != null && car.getManufacturer() == null){
		car.setManufacturer(carManufacturer);
	}
	if(car != null && car.getEngine() != null && car.getEngine().getEngineManufacturer() == null){
		car.getEngine().setEngineManufacturer(engineManufacturer);
	}
	engine = car.getEngine();
	carManufacturer = car.getManufacturer();
	engineManufacturer = car.getEngine().getEngineManufacturer();
%>
<h1>Car details</h1>
<form>
  <p>
    <b>Manufacturer: </b>
    <span><%=carManufacturer.getName()%></span>
  </p>
  <p>
   	<b>Model: </b>
    <span><%=car.getModel() %></span>
  </p>
  <p>
    <b>Engine: </b>
    <span><%=engine.getEngineName() %></span>
  </p>
  <p>
    <b>Color: </b>
    <span><%=car.getColor() %></span>
  </p>
  <p>
   	<b>Price: </b>
    <span><%=car.getPrice() %></span>
  </p><br>
</form>

<h2>Engine information</h2>
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
  </p>  
  <br><br>
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
  <br>
</form>

<h2>Contact information</h2>
<form>
	<p>
    <span><%=car.getManufacturer().getName() %> <br>
	    <%=car.getManufacturer().getAddress() %> <br>
	    <%=car.getManufacturer().getContactNumber() %>
	</span>
	</p> 
  <br><br><br>
  <p>
	<input type="submit" value="Home" formaction="cars" formmethod="post">
  </p>
</form>
</body>
</html>