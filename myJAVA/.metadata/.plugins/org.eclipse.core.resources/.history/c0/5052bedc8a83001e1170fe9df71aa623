package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.customer.dto.Customer;
import com.my.util.Attach;

public class SignupController extends CustomerController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ObjectMapper mapper = new ObjectMapper(); //JSON문자열만드는 API
		Map<String, Object> map = new HashMap<>(); //응답내용
		
		try{
			Attach attach = new Attach(request);
			String id = attach.getParameter("id");
			String name = attach.getParameter("name");
			String pwd = attach.getParameter("pwd");
			Customer c = new Customer(id, name, pwd, null);
			service.signup(c);
			
			try {
				String originProfileFileName = attach.getFile("f1").get(0).getName();			
				attach.upload("f1", id+"_profile_" + originProfileFileName);
			}catch(Exception e) {
				
			}
			try {
				String originIntroFileName = attach.getFile("f2").get(0).getName();			
				attach.upload("f2", id+"_intro_" + originIntroFileName);			
			}catch(Exception e) {
				
			}
			map.put("status", 1);
			map.put("msg", "가입성공");
		}catch(Exception e) {
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg", e.getMessage());
		}
		
		out.print(mapper.writeValueAsString(map));
		return null;
	}

}
