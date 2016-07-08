package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TranscriptDao;
import daoImpl.mock.TranscriptSQLDao;

/**
 * Servlet implementation class addgrade
 */
@WebServlet("/addgrade")
public class addgrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addgrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		int SectionNo=(int)request.getAttribute("SectionNo");
		String ssn=(String)request.getAttribute("ssn");
		int grade=Integer.parseInt(request.getParameter("grade"));
		
		TranscriptDao trdao=new TranscriptSQLDao();
		trdao.addgrade(grade, SectionNo, ssn);
		
		//返回到该课程的选课学生页面
		request.setAttribute("SectionNo", SectionNo);
		request.getRequestDispatcher("../pages/studentsOfSection.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
