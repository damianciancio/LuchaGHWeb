<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.Personaje" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Personaje> list;
	
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

<form method="post">

<table>
  <tbody>
	<tr>
	  <td colspan="2" style="text-align: center; "> Elecci&oacute;n de personaje! </td>
	</tr>
	<tr>
	  <td>
	    <select id="personajeIzq">
	    	<% for (Personaje per : list) { %>
	    	<option value="<%= per.getId() %>"> <%= per.getNombre() %> </option>
	    	<% } %>
	    </select>
	  </td>
	  <td>
	    <select id="personajeDer">
	    	<% for (Personaje per : list) { %>
	    	<option value="<%= per.getId() %>"> <%= per.getNombre() %> </option>
	    	<% } %>
	    </select>
	  </td>
	</tr>
	<tr>
	  <td style="text-align: right; ">
	    <button id="btnComenzar"> Comenzar! </button>
	  </td>
	</tr>
  </tbody>
</table>

</form>

</body>
</html>