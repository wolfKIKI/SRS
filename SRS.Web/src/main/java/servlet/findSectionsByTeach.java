package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class findSectionsByTeach
 */
@WebServlet("/findSectionsByTeach")
public class findSectionsByTeach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findSectionsByTeach() {
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
	
	
	String name=request.getParameter("name");
	SectionDao sedao=new SectionSQLDao();
	List<Section> sections=new ArrayList<Section>();
	sections=sedao.getSections(name);
	
	request.setAttribute("list", sections);
	request.getRequestDispatcher("../pages/sectionsByTeach.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
