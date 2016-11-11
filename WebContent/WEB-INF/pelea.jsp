<%@page import="entities.Personaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Personaje perIzq;
	Personaje perDer;

	if (session.getAttribute("PerIzq") instanceof Personaje)
		perIzq = (Personaje)session.getAttribute("PerIzq");
	else perIzq = new Personaje();
	if (session.getAttribute("PerDer") instanceof Personaje)
		perDer = (Personaje)session.getAttribute("PerDer");
	else perDer = new Personaje();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>War!!</title>
</head>
<body>
	<h1>War!!</h1>
	
  <table>
	<tbody>
	  <tr>
	    <td id="nombreIzq" colspan="2"> <%= perIzq.getNombre() %> </td>
	    <td id="nombreDer" colspan="2"> <%= perDer.getNombre() %> </td>
	  </tr>
	  <tr>
	    <td id="vidaIzq">
	      <label id="lblVidaIzq"> Vida </label> 
        </td>
        <td>
	      <input type="text" id="txtVidaIzq" style="width: 50px; " disabled="disabled" value="<%= "" %>" /> 
	    </td>
	    <td id="vidaDer"> 
	      <label id="lblVidaDer"> Vida </label>
        </td>
        <td>
	      <input type="text" id="txtVidaDer" style="width: 50px; " disabled="disabled" value="<%= "" %>" /> 
	    </td>
	  </tr>
	  <tr>
	    <td id="energiaIzq"> 
	      <label id="lblEnergiaIzq"> Energia </label> 
        </td>
        <td>
	      <input type="text" id="txtEnergiaIzq" style="width: 50px; " disabled="disabled" value="<%= "" %>" /> 
        </td>
	    <td id="energiaDer"> 
	      <label id="lblEnergiaDer"> Energia </label> 
        </td>
        <td>
	      <input type="text" id="txtEnergiaDer" style="width: 50px; " disabled="disabled" value="<%= "" %>" />
	    </td>
	  </tr>
	</tbody>
	<tfoot>
	  <tr>
	    <td colspan="2"> 
	      <div>
	        <input id="rdbAtacar" name="accion" value="atacar" type="radio" />
	        <label id="lblAtacar" for="rdbAtacar"> Atacar </label>
	        <input type="text" id="txtAtacar" name="Atacar" style="width: 30px; " />
	      </div>
	      <div>
	        <input id="rdbDefender" name="accion" value="defender" type="radio" />
	        <label id="lblDefender" for="rdbDefender"> Defender </label>
	      </div>
	    </td>
	    <td>
	    </td>
	    <td>
	      <input type="submit" value="Listo!" style="width: 100%; height: 100%; " />
	    </td>
	  </tr>
	</tfoot>
  </table>
</body>
</html>