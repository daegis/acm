package red.sif.service;

import red.sif.beans.ActionClient;
import red.sif.beans.Client;
import red.sif.beans.ClientUpdateBean;
import red.sif.dao.ACDAO;
import red.sif.dao.ActionDAO;
import red.sif.dao.ClientDAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/26 16:34.
 */
public class ACService {
    ACDAO acdao = new ACDAO();
    ActionDAO actionDAO = new ActionDAO();

    public void addJoin(long addedClientKey, String[] joints) throws SQLException {
        // aid cid acorder acdate acprice acdiscount acprecharge acpremethod acisready
        //  -   -     x       -      x        -           -            -         -
        //获取acorder 查询 aid在 活动表中的个数返回这个值
        int[] order = new int[joints.length];
        for (int i = 0; i < joints.length; i++) {
            int thisOrder = acdao.getClientCountInAction(joints[i]);
            order[i] = thisOrder;
        }
        //获取acprice 查询aid在 活动中的价格
        int[] price = new int[joints.length];
        for (int i = 0; i < joints.length; i++) {
            int thisPrice = actionDAO.getActionPrice(joints[i]);
            price[i] = thisPrice;
        }
        Date date = new Date();
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        for (int i = 0; i < joints.length; i++) {
            acdao.acjoin(joints[i], addedClientKey, order[i] + 1,
                    sdf, price[i], 0, 0, "未缴费", false);
        }
    }

    public List<ActionClient> getActionClient(String aid) throws SQLException {
        // 多表查询
        List<ActionClient> actionClientList = acdao.getClientsInAction(aid);
        int price = actionDAO.getPrice(aid);
        for (ActionClient actionClient : actionClientList) {
            actionClient.setAcprice(price + "");
        }
        return actionClientList;
    }

    public ActionClient getActionClientByACid(String aid, String cid) throws SQLException {
        ActionClient properClientInAction = acdao.getProperClientInAction(aid, cid);
        int price = actionDAO.getPrice(aid);
        properClientInAction.setAcprice(price + "");
        return properClientInAction;
    }

    public void doClientUpdate(ClientUpdateBean clientUpdateBean) throws SQLException {
        // 调用Rosemary补充要自动生成的信息,可能访问数据库
        // 将这个更新后的人分别提交 acjoin表和 clients表
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.doClientUpdate(clientUpdateBean);
        ACDAO acdao = new ACDAO();
        acdao.doClientUpdate(clientUpdateBean);
    }
}
