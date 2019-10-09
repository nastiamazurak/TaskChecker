package app.servlets;

import app.entities.List;
import app.entities.User;
import app.services.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



       ArrayList<List> todoList = null;
       ListService service = new ListService();
       User user = (User) req.getSession(false).getAttribute("user");
       try {
           todoList = ListService.ShowLists(user);

           if (todoList == null) {
               req.setAttribute("emptyList", "You don`t have any tasks now.");
           } else {
               req.setAttribute("UserList", todoList);
           }


       } catch (SQLException e) {
           e.printStackTrace();
       }



       req.getRequestDispatcher("home.jsp").forward(req, resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{



       String content  = req.getParameter("content");
       User user = (User) req.getSession(false).getAttribute("user");

        ListService service = new ListService();
        try {
            service.AddList(user.getId(), content);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        resp.sendRedirect(req.getContextPath()+"/home");
   }





}
