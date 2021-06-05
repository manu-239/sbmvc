<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.engine.enginecomponent.dto.*" 
    import="java.util.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars</title>
<link href="css/home.css" rel="stylesheet">
</head>
<body>
<% 
List<Car> cars = (List<Car>) request.getAttribute("cars");
if(cars == null || cars.size() == 0){
%>
	<h1>No data available</h1>
<%
}
else{
%>
<form>
<table>
    <tr>
        <th id="th01" colspan="6">Welcome to Car World</th>
    </tr>
    <tr>
    	<th scope="col" width=50></th>
    	<th scope="col">Manufacture</th>
        <th scope="col">Model</th>
        <th scope="col">Color</th>
        <th scope="col">Engine</th> 
        <th scope="col">Price</th>
    </tr>
	<%  for(int i=0;i<cars.size();i++){
			Car car = cars.get(i);
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
	    <tr>
	    	<% if(i==0) {%>
	        <td><input type="radio" name="carId" value=<%=car.getCarId() %> checked="checked"></input></td>
	        <%}else{%>
	        <td><input type="radio" name="carId" value=<%=car.getCarId() %>></input></td>
	        <%}%>
	        <td><%=carManufacturer.getName()%></td>
	        <td><%=car.getModel()%></td>
	        <td><%=car.getColor()%></td>
	        <td><%=engine.getEngineName()%></td>
	        <td><%=car.getPrice()%></td>
	    </tr>
    <% } %>
</table>
<br>
<input type="submit" value="View" formaction="cardtl" formmethod="get">&ensp;
<input type="submit" value="Add" formaction="addcar" formmethod="get">&ensp;
<input type="submit" value="Delete" formaction="delcar" formmethod="get">&emsp;&emsp;&emsp;&emsp;
<input type="submit" value="Engines" formaction="enginelist" formmethod="post">&ensp;
<input type="submit" value="Manufactures" formaction="manufactureslist" formmethod="post">
</form>
<% } %>
</body>
</html>