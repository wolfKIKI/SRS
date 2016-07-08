package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.TranscriptDao;
import daoImpl.mock.TranscriptSQLDao;
import service.dto.AjaxResult;

/**
 * Servlet implementation class enrollCourseServlet
 */
@WebServlet("/enrollCourseServlet")
public class enrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String ssn=request.getParameter("ssn");
		List selecteds=(List)request.getAttribute("selecteds");
		
		//选课
		TranscriptDao trdao=new TranscriptSQLDao();
		trdao.addTranscriptEntries(selecteds, ssn);
		PrintWriter out = response.getWriter();
	    
		try {
          
			//System.out.println(AjaxResult.Success("选课成功！"));
			//out.print(AjaxResult.Success("选课成功！"));
			out.print(AjaxResult.error("选课失败！已经选修了相同的课程！"));
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AjaxResult.error("选课失败！原因....");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
