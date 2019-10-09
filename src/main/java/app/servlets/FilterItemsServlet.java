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

@WebServlet("/list/filter/*")
public class FilterItemsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer filterId = Integer.parseInt(req.getPathInfo().replace("/", ""));
        User user = (User) req.getSession(false).getAttribute("user");

        ArrayList<List> todoList = null;

        ListService service = new ListService();
        try {
            todoList = service.filterItems(filterId, user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (todoList == null) {
            req.setAttribute("emptyList", "You don`t have any tasks now.");
        } else {
            req.setAttribute("UserList", todoList);
        }


        //req.getRequestDispatcher("home.jsp").forward(req, resp);
        //resp.sendRedirect(req.getContextPath()+"/home");

    }
}
