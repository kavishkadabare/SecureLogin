package LoginPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String un ="kavishka";
	private String pw = "123";
			
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		HttpSession session = request.getSession();
		
		
		
		String userName = request.getParameter("uname");
		String password =  request.getParameter("psw");
		
		if(userName.equals(this.un)) {
			if(password.equals(this.pw)) {
				String token = generaeCSRFTokenX();
				String sessionId = session.getId();
				CSRFToken.sessionId = sessionId;
				CSRFToken.token = token;
				
				Cookie Kcookie =  this.createCookie("test_cookie", sessionId );
				response.addCookie(Kcookie);	
				request.setAttribute("csrfToken", token);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Password");
				response.sendRedirect("Login.jsp");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Invalid User Name");
			response.sendRedirect("Login.jsp");
		}
		
		
	}
	
	public static String generaeCSRFTokenX() {
		
		String CSRFtoken = "";
		 try {
             SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
             Integer myInt = sr.nextInt();
             CSRFtoken = myInt.toString();
             
         } catch (Exception e) {
        	e.printStackTrace();
         } 
		 
		 System.out.println(CSRFtoken);
		 return CSRFtoken;
      
     }
	
	private Cookie createCookie(String cookieName, String cookieValue) {
	    Cookie cookie = new Cookie(cookieName, cookieValue);
	    cookie.setPath("/");
	    cookie.setMaxAge(60*60*24);
	    cookie.setHttpOnly(true);
	    cookie.setSecure(true);
	    return cookie;
	}
		
	}
	


