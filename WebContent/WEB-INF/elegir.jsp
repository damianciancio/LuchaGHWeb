<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.Personaje" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Personaje> list;
	String error = "";
	if (session.getAttribute("error") instanceof String)
		error = (String)session.getAttribute("error"); 

	if (session.getAttribute("personajeList") instanceof ArrayList)
		list = (ArrayList<Personaje>) session.getAttribute("personajeList"); 
	else
		list = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elecci&oacute;n de personajes</title>
</head>
<body>

<form method="GET">

<table>
  <tbody>
	<tr>
	  <td colspan="2" style="text-align: center; "> Elecci&oacute;n de personaje! </td>
	</tr>
	<tr>
	  <td>
	    <select id="personajeIzq" name="personajeIzq">
	    	<% for (Personaje per : list) { %>
	    	<option value="<%= per.getId() %>"> <%= per.getNombre() %> </option>
	    	<% } %>
	    </select>
	  </td>
	  <td>
	    <select id="personajeDer" name="personajeDer">
	    	<% for (Personaje per : list) { %>
	    	<option value="<%= per.getId() %>"> <%= per.getNombre() %> </option>
	    	<% } %>
	    </select>
	  </td>
	</tr>
	<tr>
	  <td colspan="2" style="text-align: right; ">
	    <input type="submit" value="Comenzar!" id="btnComenzar" />
	  </td>
	</tr>
  </tbody>
</table>

<div style="color: #f00; "><%= error %></div>

</form>

</body>
</html>