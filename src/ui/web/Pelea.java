package ui.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
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
		String idIzq = request.getParameter("personajeIzq");
		String idDer = request.getParameter("personajeDer");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/pelea.jsp").forward(request, response);
	}

}
