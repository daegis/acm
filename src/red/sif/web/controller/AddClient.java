package red.sif.web.controller;

import org.apache.commons.beanutils.BeanUtils;
import red.sif.beans.Client;
import red.sif.service.ACService;
import red.sif.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by XIAN. Yingda on 2017/6/26 16:00.
 */
@WebServlet(name = "AddClient", urlPatterns = "/addClient")
public class AddClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Client client = new Client();
        try {
            BeanUtils.populate(client, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "表单填写遇到严重错误,请重试或者联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        String[] joints = request.getParameterValues("joints");
        ClientService cs = new ClientService();
        long addedClientKey = 0;
        try {
            addedClientKey = cs.addClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        ACService acService = new ACService();
        try {
            acService.addJoin(addedClientKey, joints);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        response.sendRedirect(request.getContextPath() + "/welcome");
    }
}
