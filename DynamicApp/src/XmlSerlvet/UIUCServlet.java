package XmlSerlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UIUCServlet
 */
@WebServlet(description = "This is my first Servlet", urlPatterns = { "/UIUC" })
public class UIUCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("Text/html");
		String sid = request.getParameter("sid");
		
		
		String[] items={"lock","NikeShoes","iphones5","NikeSweatShirts","HeadPhone","macbook"};
		String ProductName = items[Integer.parseInt(sid)-1];
		System.out.println(ProductName);
		
		Map<String, Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if(cart == null){
			cart = new HashMap<String, Integer>();
		}
		//we have a cart
		if(cart.containsKey(ProductName)){
			int num = cart.get(ProductName);
			cart.put(ProductName, num+1);
		}else{
			cart.put(ProductName, 1);
		}
		
		//connect the database to get the price
//		Map<String, Double> databaseprice= new HashMap<String,Double>();
//		databaseprice.put("001", 5.00);
//		databaseprice.put("002",50.00);
//		databaseprice.put("003",500.00);
//		databaseprice.put("004",49.00);
//		databaseprice.put("005",30.00);
//		databaseprice.put("006",1300.00);
		
		//let cart in session
		request.getSession().setAttribute("cart", cart);
		
		response.setContentType("text/html");
		response.getWriter().println("Your items have been put on cart, "+"<a href='http://localhost:8080/DynamicApp/Session/cart.jsp'> look up</a>");
	
		//out.println("<h1>Hello, </h1>"+"<h1>"+"</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
