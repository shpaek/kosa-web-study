package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.exception.FindException;
import com.my.product.dto.Product;
import com.my.product.service.ProductService;

@RestController
public class CartController {

	@Autowired
	ProductService service;
	
	@GetMapping(value = "/cartlist", produces = "application/json;charset=UTF-8")
	public List<Map<String,Object>> cartlist(HttpSession session){
		Map<String,Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		List<Map<String,Object>> list = new ArrayList<>();
		if(cart == null) {
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "장바구니가 비었습니다");
			list.add(map);
		}else {
			for(String prodNo : cart.keySet()) {
				int quantity = cart.get(prodNo);
				Map<String, Object> map = new HashMap<>();		
				try {
					Product p = service.findByProdNo(prodNo);
					map.put("product", p);
					map.put("quantity", quantity);
					list.add(map);
				} catch (FindException e) {
					e.printStackTrace();
				}
			}			
		}
		return list;
	}
	
	@GetMapping("/addcart")
	public void addcart(String prodNo, int quantity, HttpSession session) {
		System.out.println("in addcart: " + session.getId());
		System.out.println(prodNo);
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
