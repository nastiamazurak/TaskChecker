package app.servlets;

import app.entities.User;
import app.exceptions.PasswordException;
import app.exceptions.UserRegisteredException;
import app.services.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("register.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String destPage = "register.jsp";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        UserService service = new UserService();
        User user = null;

        String encodedPass = service.encodePassword(password);
        String encodedConfirm = service.encodePassword(confirm);

        try {
            user = service.RegisterUser(email,password,confirm);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UserRegisteredException e) {
            request.setAttribute("emailError", "this user is already registered.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }
            catch (PasswordException e) {

            request.setAttribute("passError", "Error! Passwords are not the same! Try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }




        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/home");
            //request.getRequestDispatcher("home.jsp");

        }

    }
}



