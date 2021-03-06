

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import LoginPackage.CSRFToken;


/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {       
    	
    	super();
    	System.out.println("Welcome servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
        String storedToken = CSRFToken.getToken(session.getId());
		boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	
		if(ajax) {
        	
        	response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
            response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
            response.getWriter().write(storedToken); 
            System.out.println("Ajax call token:  "+storedToken);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
		
		
		
		 HttpSession session = request.getSession();
	        String storedToken = CSRFToken.getToken(session.getId());
	        String token = request.getParameter("token");
	        
	        
	        
	        token = token.replace("/","");
	        if (storedToken.equals(token)) {
	               System.out.println("You are a valid User");
	               JOptionPane.showMessageDialog(null, "Valid Request!!!");
	               //Continue with Application
	               }
	        else {
	        	System.out.println("You are not a valid User!! WARNING!!! WARNING!!!");
	        	//JOptionPane.showMessageDialog(null, "Invalid Request");
	        	
	        }
	}
	

}
