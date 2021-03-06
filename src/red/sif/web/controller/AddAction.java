package red.sif.web.controller;

import org.apache.commons.beanutils.BeanUtils;
import red.sif.beans.Action;
import red.sif.service.ActionService;

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
 * Created by XIAN. Yingda on 2017/6/25 21:46.
 */
@WebServlet(name = "AddAction", urlPatterns = "/addAction")
public class AddAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Action action = new Action();
        try {
            BeanUtils.populate(action, parameterMap);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "表单填写遇到严重错误,请重试或者联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        ActionService as = new ActionService();
        try {
            as.addAction(action);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        response.sendRedirect(request.getContextPath() + "/action_show");
    }
}
