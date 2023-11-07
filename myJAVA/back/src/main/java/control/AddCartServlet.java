package control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "http://192.168.1.20:5500");//"http://127.0.0.1:5500");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String prodNo = request.getParameter("prodNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		HttpSession session = request.getSession();
		System.out.println("in addcart: " + session.getId());
		Map<String, Integer> cart = (Map)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}
		
		Integer oldQuantity = cart.get(prodNo);
		if(oldQuantity != null) {
			quantity += oldQuantity;
		}
		cart.put(prodNo, quantity);
		System.out.println("JSESSIONID:" + session.getId());
		System.out.println(cart);		
	}
}