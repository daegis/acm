package red.sif.web.controller;

import red.sif.beans.Action;
import red.sif.beans.ActionClient;
import red.sif.dao.ACDAO;
import red.sif.service.ACService;
import red.sif.service.ActionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by XIAN. Yingda on 2017/6/27 15:18.
 */
@SuppressWarnings("Duplicates")
@WebServlet(name = "ShowClientAction", urlPatterns = "/showClientAction")
public class ShowClientAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        String cid = request.getParameter("cid");
        ACService acService = new ACService();
        ActionClient actionClient = null;
        try {
            actionClient = acService.getActionClientByACid(aid, cid);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        ActionService as = new ActionService();
        Action action = null;
        try {
            action = as.findAction(aid);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        request.setAttribute("client", actionClient);
        request.setAttribute("action", action);
        request.getRequestDispatcher("/WEB-INF/jsp/client_update.jsp").forward(request, response);
    }
}
