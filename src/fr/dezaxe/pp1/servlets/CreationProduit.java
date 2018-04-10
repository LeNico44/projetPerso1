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

import fr.dezaxe.pp1.beans.IProduit;
import fr.dezaxe.pp1.beans.Loader;
import fr.dezaxe.pp1.enums.Magasin;
import fr.dezaxe.pp1.forms.CreationProduitForm;
import fr.dezaxe.pp1.others.Constante;

/**
 * Servlet implementation class Produit
 */
@WebServlet("/Produit")
public class CreationProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATTR_ENUM_MAGASINS = "enumMagasins";
	private static final String VUE = "/WEB-INF/creationproduit.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATTR_ENUM_MAGASINS, Magasin.values());
		
		menuActif(request);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATTR_ENUM_MAGASINS, Magasin.values());
		
		// Création du manager factory pour la base de données "projet_perso_1"  nommé ici "pp1".
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pp1");
		EntityManager em = emf.createEntityManager();
		
		menuActif(request);
		
		// appelle à Cre&tionProduitForm
		/*Préparation de l'objet form*/
		CreationProduitForm form = new CreationProduitForm();
		
		/* Traitement de la requête et récupération du bean en résultant */
		IProduit produit = form.creerProduit(request);
		
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	private void menuActif(HttpServletRequest request) {
		String creerProduitActive = Constante.ACTIVE;
		request.setAttribute("creerProduitActive", creerProduitActive);
	}

}
