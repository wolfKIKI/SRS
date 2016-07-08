package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import model.Student;

/**
 * Servlet implementation class toDifferentPage
 */
@WebServlet("/toDifferentPage")
public class toDifferentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toDifferentPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//获取登陆者身份
		String type=(String)request.getAttribute("type");
		//获取登陆者信息
		Person p=new Student(null,null,null,null);
		p=(Person)request.getAttribute("p");
		
		request.setAttribute("p", p);//保存人物信息，传给下一页面
		
		//通过type值的不同，跳转不同页面
		if(type.equals("student")){
			request.getRequestDispatcher("pages/student.jsp").forward(request, response);
		}else if(type.equals("professor")){
			request.getRequestDispatcher("pages/professor.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
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
