package app.servlets;

import app.services.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/list/edit/*")
public class EditServlet extends HttpServlet {

    @Override
   public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Integer id = Integer.parseInt(req.getPathInfo().replace("/", ""));
        //Integer id = Integer.parseInt(req.getParameter("id"));
        ListService service = new ListService();
        String content = req.getParameter("content");


        try {
            service.updateList(id, content);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //req.getRequestDispatcher("home.jsp");
    }
}
