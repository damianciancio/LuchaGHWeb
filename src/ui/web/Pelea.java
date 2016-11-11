package ui.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import util.PersonajeInvalidoException;
import util.PersonajeNoEncontradoException;
import entities.*;

@WebServlet("/Pelea")
public class Pelea extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PartidaLogic parControl;

    public Pelea() {
    	super();
    	parControl = new PartidaLogic();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupero la partida empezada o empiezo una nueva
		if (request.getSession().getAttribute("partida") != null) {
			parControl = (PartidaLogic)request.getSession().getAttribute("partida");
			
			//Capturo los datos ingresados
			String accion = request.getParameter("accion");
			int ptsAtaque;
			try {
				ptsAtaque = Integer.parseInt(request.getParameter("Atacar"));
			}
			catch(Exception e) {
				//Si no puso puntos de ataque o lo que ingresó no era válido
				ptsAtaque = 0;
				accion = "defender";
			}
			
			try {
				if (accion.equals("atacar")) {
					parControl.atacar(ptsAtaque);
				}
				else {
					parControl.defender();
				}
			}
			catch(Exception ex) {
				//Ya validé que no tire exception pero bueno
			}
			
		}
		else {
			Personaje pj1 = (Personaje)request.getSession().getAttribute("PerIzq");
			Personaje pj2 = (Personaje)request.getSession().getAttribute("PerDer");
			
			try {
				parControl.comenzarPelea(pj1, pj2);
			} catch (PersonajeNoEncontradoException e) {
				e.printStackTrace();
			} catch (PersonajeInvalidoException e) {
				e.printStackTrace();
			}
		}
		
		request.getSession().setAttribute("partida", parControl);
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
	}

}
