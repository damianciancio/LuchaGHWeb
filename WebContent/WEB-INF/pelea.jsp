<%@page import="entities.*"%>
<%@page import="logic.PartidaLogic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Personaje perIzq;
	Personaje perDer;
	PartidaLogic partida;
	
	if (session.getAttribute("partida") instanceof PartidaLogic)
		partida = (PartidaLogic)session.getAttribute("partida");
	else partida = new PartidaLogic();

	perIzq = partida.getP1().getP();
	perDer = partida.getP2().getP();

	String vidaIzq = Integer.toString(partida.getP1().getVidaActual()) + " / " + Integer.toString(perIzq.getVida());
	String vidaDer = Integer.toString(partida.getP2().getVidaActual()) + " / " + Integer.toString(perDer.getVida());

	String eneIzq = Integer.toString(partida.getP1().getEnergiaActual()) + " / " + Integer.toString(perIzq.getEnergia());
	String eneDer = Integer.toString(partida.getP2().getEnergiaActual()) + " / " + Integer.toString(perDer.getEnergia());
	
	String turnoDe = partida.getTurnoDe().getP().getNombre();
	
	String head;
	String btnListoEnabled;
	
	if (partida.isPartidaVigente()) {
		head = "<span> Turno de " + turnoDe + " </span>";
		btnListoEnabled = "";
	}
	else { 
		head = "<span style=\"color: #090; font-weight: bold; \"> El fulano <u>" + turnoDe + "</u> Gano! </span>";
		btnListoEnabled= " disabled=\"disabled\"";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>War!!</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<body>
	<h1>War!!</h1>
	
<form method="get">
	
  <table>
    <thead>
      <tr>
        <td colspan="4"> <%= head %> </td>
      </tr>
    </thead>
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
	      <input type="text" id="txtVidaIzq" style="width: 50px; " disabled="disabled" value="<%= vidaIzq %>" /> 
	    </td>
	    <td id="vidaDer"> 
	      <label id="lblVidaDer"> Vida </label>
        </td>
        <td>
	      <input type="text" id="txtVidaDer" style="width: 50px; " disabled="disabled" value="<%= vidaDer %>" /> 
	    </td>
	  </tr>
	  <tr>
	    <td id="energiaIzq"> 
	      <label id="lblEnergiaIzq"> Energia </label> 
        </td>
        <td>
	      <input type="text" id="txtEnergiaIzq" style="width: 50px; " disabled="disabled" value="<%= eneIzq %>" /> 
        </td>
	    <td id="energiaDer"> 
	      <label id="lblEnergiaDer"> Energia </label> 
        </td>
        <td>
	      <input type="text" id="txtEnergiaDer" style="width: 50px; " disabled="disabled" value="<%= eneDer %>" />
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
	      <input type="submit" value="Listo!" style="width: 100%; height: 100%; " <%= btnListoEnabled %>/>
	    </td>
	  </tr>
	  <tr>
	    <td colspan="4">
	      <textarea rows="10" cols="40" style="width: 100%; white-space: pre;" disabled="disabled">
	        <%= partida.getLogPelea() %>
	      </textarea>
	    </td>
	  </tr>
	</tfoot>
  </table>
  
 </form>
  
  <script type="text/javascript">
    $("#txtAtacar").focus(function() {$("#rdbAtacar").prop("checked","checked");});
  </script>
</body>
</html>