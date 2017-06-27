package red.sif.web.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import red.sif.beans.ActionClient;
import red.sif.beans.ClientUpdateBean;
import red.sif.service.ACService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by XIAN. Yingda on 2017/6/27 17:08.
 */
@SuppressWarnings("Duplicates")
@WebServlet(name = "UpdateClientAction", urlPatterns = "/updateClientAction")
public class UpdateClientAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
//        }
        ACService acService = new ACService();
        ClientUpdateBean clientUpdateBean = new ClientUpdateBean();
        try {
            BeanUtils.populate(clientUpdateBean, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "表单填写遇到严重错误,请重试或者联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
        try {
            acService.doClientUpdate(clientUpdateBean);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "遇到数据库问题,请联系管理员");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }

        response.setCharacterEncoding("utf-8");
        response.getWriter().write("提交成功");
    }
}
