

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("Do post lkgdalkgj");
		//doGet(request, response);
		
		Cookie[] cookies = request.getCookies();
		
		String cookieValue = null;
		for(Cookie cookie : cookies){
		    if("test_cookie".equals(cookie.getName())){
		    	cookieValue = cookie.getValue();
		    }
		}
		
		 HttpSession session = request.getSession();
	        String storedToken = session.getAttribute("crsfToken").toString();
	        String token = request.getParameter("token");
	        System.out.println(storedToken +"     "+ token);
	        //do check
	        
	        token = token.replace("/","");
	        if (storedToken.equals(token)) {
	               System.out.println("You are a valid User");


	        } else {
	        	System.out.println("You are not a valid User!! WARNING!!! WARNING!!!");
	        	}
	}
	

}
