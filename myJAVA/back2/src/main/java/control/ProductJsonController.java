package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.exception.FindException;
import com.my.product.dto.Product;

public class ProductJsonController extends ProductController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//응답출력스트림얻기
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();

		//요청전달데이터 얻기
		String prodNo = request.getParameter("prodno");
		try {
			Product p = service.findByProdNo(prodNo);
			String jsonStr = mapper.writeValueAsString(p);			
			out.print(jsonStr);
		} catch (FindException e) {
			e.printStackTrace();
			//out.print("{\"msg\":\"" + e.getMessage() + "\"}");
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			out.print(jsonStr);			
		}
		return null;
	}

}
