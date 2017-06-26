package red.sif.web.controller;

import red.sif.beans.Action;
import red.sif.service.ActionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/25 22:33.
 */
@WebServlet(name = "showAction", urlPatterns = "/showAction")
public class showAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionService as = new ActionService();
        List<Action> list = null;
        try {
            list = as.getAllActions();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        request.setAttribute("actionList", list);
        request.getRequestDispatcher("/WEB-INF/jsp/action_show.jsp").forward(request, response);
    }
}
