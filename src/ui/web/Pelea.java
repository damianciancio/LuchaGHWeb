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

    public Pelea() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartidaLogic control = new PartidaLogic();
		PersonajeLogic perControl = new PersonajeLogic();
		
		ArrayList<Personaje> personajeList;
		
		try {
			personajeList = perControl.GetAll();
		}
		catch (Exception ex)
		{
			personajeList = new ArrayList<Personaje>();
		}
		
		request.getSession().setAttribute("personajeList", personajeList);
		

		request.getRequestDispatcher("WEB-INF/elegir.jsp").forward(request, response);
	}

}
