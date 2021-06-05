<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.engine.enginecomponent.dto.*" 
    import="java.util.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Engines</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<% 
List<Engine> engines = (List<Engine>) request.getAttribute("engines");
if(engines == null || engines.size() == 0){
%>
	<h1>No data available</h1>
<%
}
else{
%>
<form>
<table>
    <tr>
        <th id="th01" colspan="5">Engines</th>
    </tr>
    <tr>
    	<th scope="col" width=50></th>
        <th scope="col">Engine name</th>
        <th scope="col">Manufacture</th>
        <th scope="col">Type</th>
        <th scope="col">Displacement(in cc)</th> 
    </tr>
    <%  for(int i=0;i<engines.size();i++){
    		Engine engine = engines.get(i);
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
			    <tr>
			    	<% if(i==0) { %>
			        <td><input type="radio" name="engineId" value=<%=engine.getEngineId() %> checked="checked"></input></td>
			        <%}else{%>
			        <td><input type="radio" name="engineId" value=<%=engine.getEngineId() %>></input></td>
			        <%}%>
			        <td><%=engine.getEngineName()%></td>
			        <td><%=engineManufacturer.getName()%></td>
			        <td><%=engine.getEngineType()%></td>
			        <td><%=engine.getDisplacement()%></td>
			    </tr>
    	<% } %>
</table>
<br>
<input type="submit" value="View" formaction="enginedtl" formmethod="get">&ensp;
<input type="submit" value="Add" formaction="addengine" formmethod="get">&ensp;
<input type="submit" value="Delete" formaction="delengine" formmethod="get">&emsp;&emsp;&emsp;&emsp;
<input type="submit" value="Home" formaction="cars" formmethod="post">&ensp;
</form>
<% } %>
</body>
</html>