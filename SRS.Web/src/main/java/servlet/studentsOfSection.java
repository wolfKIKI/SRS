package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TranscriptDao;
import daoImpl.mock.TranscriptSQLDao;

/**
 * Servlet implementation class studentsOfSection
 */
@WebServlet("/studentsOfSection")
public class studentsOfSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentsOfSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int SectionNo=Integer.parseInt(request.getParameter("SectionNo"));
		
		TranscriptDao trdao=new TranscriptSQLDao();
		List<String> ssns=new ArrayList<String>();
		ssns=trdao.getStudentBySection(SectionNo);
		
		//´«ÖµÌø×ª
		request.setAttribute("list", ssns);
		request.setAttribute("SectionNo", SectionNoS);
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
