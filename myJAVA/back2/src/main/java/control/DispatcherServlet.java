package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String envFileName = "control.properties";
	private Properties env;

	public DispatcherServlet() {
		super();
	}

	@Override
	public void init() throws ServletException{
		super.init();
		env = new Properties();
		ServletContext sc = this.getServletContext();
		String realPath = sc.getRealPath("WEB-INF\\classes\\com\\my\\env\\"+envFileName);
		System.out.println("in DispatcherServlet의 init(): realPath="+realPath);
		try{
			env.load(new FileInputStream(realPath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("request.getServletPath()="+request.getServletPath());
//      if(request.getServletPath().equals("/productjson")) {
//         ProductJsonController control = new ProductJsonController();
//         control.execute(request, response);
//      }else {
//         ProductListJsonController control = new ProductListJsonController();
//         control.execute(request, response);
//      }
      String className = env.getProperty(request.getServletPath());
      try {
         Class clazz = Class.forName(className); //클래스 이름에 해당하는 .class파일 찾아서 JVM으로 로드

         Controller controller = (Controller) clazz.getDeclaredConstructor().newInstance();
         //clazz.newInstance(); //객체생성
         controller.execute(request, response);
      } catch (Exception e) {
         e.printStackTrace();
      }
		 */

		//참고 
		//response.setContentType("application/json;charset=utf-8");
		//response.setHeader("Access-Control-Allow-Origin", "http://192.168.1.12:5500");
		response.setHeader("Access-Control-Allow-Origin", "http://192.168.1.20:5173");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "*");

		System.out.println("request.getServletPath()=" + request.getServletPath());
		String className = env.getProperty(request.getServletPath());
		try {
			Class<?> clazz = Class.forName(className);//클래스이름에 해당하는 .class파일 찾아서 JVM으로 로드

			Controller controller;
			try {
				Method method = clazz.getMethod("getInstance");
				controller = (Controller)method.invoke(null);//static인 getInstance()메서드호출
			}catch(NoSuchMethodException e) {         
				controller = (Controller)clazz.getDeclaredConstructor().newInstance();
			}
			String path = controller.execute(request, response);
			if(path!=null){
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
			//controller.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
