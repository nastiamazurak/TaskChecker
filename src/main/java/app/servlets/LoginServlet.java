package app.servlets;
import app.entities.User;
import app.services.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException { }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String destPage = "login.jsp";
        String email  = request.getParameter("email");
        String password = request.getParameter("password");

       UserService service = new UserService();

       User user = null;

       user = service.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user); response.
           sendRedirect(request.getContextPath()+"/home");

        }
           //request.setAttribute("error", "Invalid email or password");
           //request.getRequestDispatcher("login.jsp").forward(request, response);

        else {

            String message = "Invalid email/password";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
