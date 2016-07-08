package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SectionDao;
import daoImpl.mock.SectionSQLDao;
import model.Section;

/**
 * Servlet implementation class deleteSection
 */
@WebServlet("/deleteSection")
public class deleteSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int SectionNo=Integer.parseInt(request.getParameter("sectionNo"));
		SectionDao sedao=new SectionSQLDao();
		sedao.delete(SectionNo);
		
		
		//再次获取sectionList，跳转至sectionList页面
		request.setCharacterEncoding("utf-8");
		
		List<Section> sections=sedao.findAll();
		request.setAttribute("list", sections);
		request.getRequestDispatcher("../pages/sectionLis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
