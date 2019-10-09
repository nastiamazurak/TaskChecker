package app.servlets;

import app.services.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/list/delete/*")
public class ListServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getPathInfo().replace("/", ""));
        ListService service = new ListService();
        try {
            service.DeleteList(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
