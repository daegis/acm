package red.sif.service;

import red.sif.beans.Action;
import red.sif.dao.ActionDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/25 22:01.
 */
public class ActionService {
    ActionDAO adao = new ActionDAO();

    // 添加一个新事件
    public void addAction(Action action) throws SQLException {
        adao.addAction(action);
    }

    public List<Action> getAllActions() throws SQLException {
        return adao.getAllActions();
    }

    public Action findAction(String aid) throws SQLException {
        List<Action> actionList = adao.findAction(aid);
        if (actionList == null || actionList.size() == 0) {
            return null;
        } else {
            return actionList.get(0);
        }
    }

    public void updateAction(Action action) throws SQLException {
        adao.updateAction(action);
    }
}
