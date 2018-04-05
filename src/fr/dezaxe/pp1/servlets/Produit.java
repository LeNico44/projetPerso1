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
import fr.dezaxe.pp1.others.Constante;

/**
 * Servlet implementation class Produit
 */
@WebServlet("/Produit")
public class Produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "url";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("enumMagasins", Magasin.values());
		String option = request.getParameter("radioProduit");
		request.setAttribute("option", option);
		
		//"url" r�cup�re l'url en cours et compare � la constante pour l'attibution de la classe "active" du lien du menu. 
		request.setAttribute(URL, request.getRequestURL());
		request.setAttribute("urlProduit", Constante.urlProduit);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/produit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("enumMagasins", Magasin.values());
		String option = request.getParameter("radioProduit");
		request.setAttribute("option", option);
		
		// Cr�ation du manager factory pour la base de donn�es "projet_perso_1"  nomm� ici "pp1".
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pp1");
		EntityManager em = emf.createEntityManager();
		
		//"url"ééééç  r�cup�re l'url en cours et compare � la constante pour l'attibution de la classe "active" du lien du menu. 
		request.setAttribute(URL, request.getRequestURL());
		request.setAttribute("urlProduit", Constante.urlProduit);
		
		IProduit produit;
		
		if("option".equals("prodemb")) {
			produit = Loader.creerProduitEmballe();
		}else {
			produit = Loader.creerProduitVrac();
		}
		
		produit.setLibelle(request.getParameter("libelle"));
		produit.setMagasin(Magasin.parseMagasin(request.getParameter("magasin")));
		
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();
			
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/produit.jsp").forward(request, response);
	}

}
