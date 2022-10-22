package ControllerPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoPackage.StudentDao;
import ModelPackage.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/register")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao = new StudentDao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/StudentRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String Departmnet = request.getParameter("Departmnet");
		String Email = request.getParameter("Email");
		String Mobile = request.getParameter("Mobile");
		String Address = request.getParameter("Address");
		
		Student s = new Student();
		s.setName(Name);
		s.setDepartment(Departmnet);
		s.setEmail(Email);
		s.setMobile(Mobile);
		s.setAddress(Address);
		
		try {
			studentDao.registerStudent(s);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/Home.jsp");
		dispatcher.forward(request, response);
	}

}
