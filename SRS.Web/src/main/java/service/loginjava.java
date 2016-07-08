package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDao;
import dao.UserDao;
import daoImpl.mock.PersonDaoImpl;
import daoImpl.mock.UserDaoImpl;
import model.Person;
import model.Student;
import model.User;

/**
 * Servlet implementation class loginjava
 */
@WebServlet("/loginjava")
public class loginjava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginjava() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("person");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		
		
		UserDao udao=new UserDaoImpl();
		User u=new User();
		u=udao.check(username, password);
		
		Person p=new Student(null,null,null,null);
		PersonDao pdao=new PersonDaoImpl();
		p=pdao.getPeByUser(u);
		
		request.setAttribute("p", p);
		request.setAttribute("type", type );
		request.getRequestDispatcher("../servlet/toDiffernetPage").forward(request, response);
	}

}
