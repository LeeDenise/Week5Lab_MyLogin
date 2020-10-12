package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
//        session.invalidate();
//        session = request.getSession();
        
        // if user session exists, redirect to home page
//        User user = (User)session.getAttribute("users");
//        if (user != null)
//        {
//            response.sendRedirect(request.getContextPath() + "/home");
//            return;
//        } else 
//        {
//            session.invalidate();
//            session = request.getSession();   
//        }
        
        // if the param "logout" exists, 
        if (request.getParameter("action") != null)
        {
            String value = request.getParameter("action");
            if (value.equals("logout"))
            {
                //invalidate the session
                session.invalidate();

                // display a message that user has successfully logged out
                request.setAttribute("message", "You logged out successfully!");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
                return;
            } 
        }
        else
        {
            User user = (User)session.getAttribute("users");
            
            // if user session exists, redirect to home page
            if (user != null)
            {
                response.sendRedirect(request.getContextPath() + "/home");
                return;
            } 
            else 
            {
                session.invalidate();
                session = request.getSession();   
            }
        
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

//        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
//                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
                
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // validates the username and psssword are not empty
        if (username == null || password == null || username.equals("") || password.equals(""))
        {       
            User user = new User(username, password);
            request.setAttribute("user", user);            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            return;
        }
        
        // passes the username and password param to the login() method of AccountService
        AccountService service = new AccountService();
        
        // if loin() returns a non-null value
        if (service.login(username, password) != null)
        {
            User user = service.login(username, password);
            
            // store the username in a session variable
            session.setAttribute("users", user);
            
            // redirect the user to the home url
            response.sendRedirect(request.getContextPath() + "/home");
        } else 
        {
            User user = new User(username, password);
            request.setAttribute("user", user);   
            
            request.setAttribute("message", "Invalid ID/Password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }   
    }
}
