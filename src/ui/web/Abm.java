package ui.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Personaje;
import logic.*;
import util.ErrorConexionException;
import util.PersonajeInvalidoException;
/**
 * Servlet implementation class Abm
 */
@WebServlet("/Abm")
public class Abm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonajeLogic controlador;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Abm() {
        super();
        controlador = new PersonajeLogic();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("controlador") == null)
		{
			request.getSession().setAttribute("controlador",controlador);
			request.getRequestDispatcher("WEB-INF/agregar.jsp").forward(request, response);
		}
		else
		{
			Personaje p = new Personaje();
			p.setDefensa(Integer.parseInt(request.getParameter("defensa")));
			p.setEnergia(Integer.parseInt(request.getParameter("energia")));
			p.setEvasion(Integer.parseInt(request.getParameter("evasion")));
			p.setNombre(request.getParameter("nombre"));
			p.setVida(Integer.parseInt(request.getParameter("vida")));
			try {
				((PersonajeLogic)request.getSession().getAttribute("controlador")).guardar(p);
			} catch (PersonajeInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ErrorConexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("www.facebook.com");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
