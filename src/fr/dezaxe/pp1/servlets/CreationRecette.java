package fr.dezaxe.pp1.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dezaxe.pp1.beans.IRecette;
import fr.dezaxe.pp1.beans.Loader;
import fr.dezaxe.pp1.dao.NoteEntityManager;
import fr.dezaxe.pp1.dao.RecetteDAO;
import fr.dezaxe.pp1.dao.RecetteDAOImpl;
import fr.dezaxe.pp1.enums.Saison;
import fr.dezaxe.pp1.forms.CreationRecetteForm;
import fr.dezaxe.pp1.others.Constante;

/**
 * Servlet implementation class Recette
 */
@WebServlet("/Recette")
public class CreationRecette extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATTR_ENUM_SAISONS = "enumSaisons";
	private static final String VUE = "/WEB-INF/creationrecette.jsp";
	
	private RecetteDAO recetteDAO = new RecetteDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationRecette() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATTR_ENUM_SAISONS, Saison.values());
		
		menuActif(request);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATTR_ENUM_SAISONS, Saison.values());
		
		menuActif(request);
		
		/*Préparation de l'objet form*/
		CreationRecetteForm form = new CreationRecetteForm();
		
		/* Traitement de la requête et récupération du bean en résultant */
		IRecette recette;
		
		if(form.getErreurs().isEmpty()) {
			try {
				recette = form.creerRecette(request);
				recetteDAO.creerRecette(recette);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		
	}
	
	private void menuActif(HttpServletRequest request) {
		String creerRecetteActive = Constante.ACTIVE;
		request.setAttribute("creerRecetteActive", creerRecetteActive);
	}

}
