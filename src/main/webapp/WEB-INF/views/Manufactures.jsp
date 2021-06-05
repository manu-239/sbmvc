<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.engine.enginecomponent.dto.*" 
    import="java.util.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manufacturer</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<% 
List<Manufacturer> manufactures = (List<Manufacturer>) request.getAttribute("manufactures");
if(manufactures == null || manufactures.size() == 0){
%>
	<h1>No data available</h1>
<%
}
else{
%>
<form>
<table>
    <tr>
        <th id="th01" colspan="4">Manufactures</th>
    </tr>
    <tr>
    	<th scope="col" width=50></th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col">Contact Number</th>
    </tr>
	<%  for(int i=0;i<manufactures.size();i++){
			Manufacturer manufacturer = manufactures.get(i);
    		if(manufacturer == null){
    			manufacturer = new Manufacturer();
    		}
		%>
	    <tr>
	    	<% if(i==0) {%>
	        <td><input type="radio" name="manufacturerId" value=<%=manufacturer.getManufacturerId() %> checked="checked"></input></td>
	         <%}else{%>
	        <td><input type="radio" name="manufacturerId" value=<%=manufacturer.getManufacturerId() %>></input></td>
	         <%}%>
	        <td><%=manufacturer.getName() %></td>
	        <td><%=manufacturer.getAddress() %></td>
	        <td><%=manufacturer.getContactNumber() %></td>
	    </tr>
    <% } %>
</table>
<br>
<input type="submit" value="Add" formaction="addmanufacturer" formmethod="get">&ensp;
<input type="submit" value="Delete" formaction="delmanufacturer" formmethod="get">&emsp;&emsp;&emsp;&emsp;
<input type="submit" value="Home" formaction="cars" formmethod="post">&ensp;
</form>
<% } %>
</body>
</html>