package fr.dezaxe.pp1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dezaxe.pp1.dao.ProduitDAO;
import fr.dezaxe.pp1.dao.ProduitDAOImpl;

/**
 * Servlet implementation class SuppressionProduit
 */
@WebServlet("/SuppressionProduit")
public class SuppressionProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ID_PRODUIT = "id_produit";
	private static final String VUE = "/produit";
    
	private ProduitDAO produitDAO = new ProduitDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =  Integer.parseInt(request.getParameter(ID_PRODUIT));
		produitDAO.supProduit(id);
		
		response.sendRedirect( request.getContextPath() + VUE );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
