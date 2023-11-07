package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int totalScore=0;
	private int totalCnt=0;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터얻기
		String star = request.getParameter("star");
		//복잡한계산
		totalScore += Integer.parseInt(star);
		totalCnt++;
		float avgScore = (float)totalScore/totalCnt;
		
		//요청 속성설정
		request.setAttribute("ts", totalScore);//총점
		request.setAttribute("tc", totalCnt);//총참여자수
		request.setAttribute("as", avgScore);//평점
		
		//JSP(VIEWER)로 이동
		RequestDispatcher rd = 
			request.getRequestDispatcher("scoreresult.jsp");
		rd.forward(request, response);
	}
}
