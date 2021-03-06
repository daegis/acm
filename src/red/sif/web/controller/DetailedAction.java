package red.sif.web.controller;

import red.sif.beans.Action;
import red.sif.beans.ActionClient;
import red.sif.beans.Client;
import red.sif.service.ACService;
import red.sif.service.ActionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/25 23:35.
 */
@SuppressWarnings("Duplicates")
@WebServlet(name = "DetailedAction", urlPatterns = "/detailedAction")
public class DetailedAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        ActionService as = new ActionService();
        Action action = null;
        try {
            action = as.findAction(aid);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        request.setAttribute("action", action);
        ACService acService = new ACService();
        List<ActionClient> actionClientList = null;
        try {
            actionClientList = acService.getActionClient(aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("clients", actionClientList);
        request.getRequestDispatcher("/WEB-INF/jsp/action_detail.jsp").forward(request, response);
    }
}
