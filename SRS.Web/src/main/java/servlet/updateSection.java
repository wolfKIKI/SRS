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
import model.Course;
import model.Professor;
import model.Section;

/**
 * Servlet implementation class updateSection
 */
@WebServlet("/updateSection")
public class updateSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSection() {
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
		int SectionNo=Integer.parseInt(request.getParameter("SectionNo"));
		int semester=Integer.parseInt(request.getParameter("semester"));
		String cName=request.getParameter("course");
		Course course=new Course();
		course.setCourseName(cName);
		String instructor=request.getParameter("instructor");
		Professor professor=new Professor(instructor,null,null,null);
		
		int seatingCapacity=Integer.parseInt(request.getParameter("seatingCapacity"));
		String room=request.getParameter("room");
		
		Section se=new Section(SectionNo,semester,course,room,seatingCapacity);
		se.setInstructor(professor);
		
		//调用update更新
		SectionDao sedao=new SectionSQLDao();
		sedao.update(se);
		
		//调用findall获得更新后的列表
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
