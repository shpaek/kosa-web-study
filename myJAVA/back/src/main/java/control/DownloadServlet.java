package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", 
				"http://192.168.1.20:5500");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		//text/html, application/json
		response.setContentType("application/octet-stream;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		ServletOutputStream sos = response.getOutputStream();
		
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		String attachesDir = "D:\\KOSA202307\\attaches";
		String fileName = id + "_" + opt + "_";
		File dir = new File(attachesDir);
		for(File file: dir.listFiles()){
			String existFileName = file.getName();
			if(existFileName.startsWith(fileName)) {
				System.out.println(existFileName+"파일입니다. 파일크기:" + file.length());
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(existFileName, "UTF-8"));
				
				FileInputStream fis = new FileInputStream(file);
				int readValue = -1;
				while((readValue = fis.read()) != -1) {
					sos.write(readValue);
				}
				sos.close();
				return;
			}
		}
		System.out.println(id + "의 프로필 파일이 없습니다");
	}

}
