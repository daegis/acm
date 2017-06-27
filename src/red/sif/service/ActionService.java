package red.sif.service;

import red.sif.beans.Action;
import red.sif.dao.ACDAO;
import red.sif.dao.ActionDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/25 22:01.
 */
public class ActionService {
    ActionDAO adao = new ActionDAO();
    ACDAO acdao = new ACDAO();

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
            Action action = actionList.get(0);
            int count = acdao.getClientCountInAction(aid);
            action.setAcount(count);
            return action;
        }
    }

    public void updateAction(Action action) throws SQLException {
        adao.updateAction(action);
    }
}
