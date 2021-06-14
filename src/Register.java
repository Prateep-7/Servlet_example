

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");          
		String e=request.getParameter("email");    
		String p=request.getParameter("pass"); 
		 HttpSession session=request.getSession();  
	     session.setAttribute("name",name);

		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prateep","root","root");  
		  
		PreparedStatement ps=con.prepareStatement("insert into userdetails values(?,?)");  
		  
		ps.setString(1,e);  
		ps.setString(2,p);  

		int i=ps.executeUpdate();  
		
		if(i>0) {
		out.println("You are successfully registered...");  
		out.println("GO TO PREVIOUS PAGE TO LOGIN");
			
		}
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
	}

}
