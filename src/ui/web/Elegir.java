package ui.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Personaje;
import logic.PersonajeLogic;

@WebServlet("/Elegir")
public class Elegir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonajeLogic perControl;
       
    public Elegir() {
        super();
        perControl = new PersonajeLogic();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtIdIzq = request.getParameter("personajeIzq");
		String txtIdDer = request.getParameter("personajeDer");
		String error = "";
		
		try {
			int idIzq = Integer.parseInt(txtIdIzq);
			int idDer = Integer.parseInt(txtIdDer);
			
			Personaje perIzq = perControl.GetById(idIzq);
			Personaje perDer = perControl.GetById(idDer);
			
			if (perIzq.equals(perDer)) {
				throw new Exception("Elija personajes distintos");
			}
			
			request.getSession().setAttribute("PerIzq", perIzq);
			request.getSession().setAttribute("PerDer", perDer);
			
			response.sendRedirect("Pelea");
			return;
		}
		catch (Exception ex) {
			error = ex.getMessage();
			if (error.equals("null")) error = "";
		}

		request.getSession().setAttribute("error", error);
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
