package red.sif.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import red.sif.beans.Action;
import red.sif.utils.DatabaseUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/25 22:03.
 */
public class ActionDAO {
    QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getDs());

    // 添加一个新事件
    public void addAction(Action action) throws SQLException {
        String sql = "INSERT INTO actions VALUES(NULL,?,?,?,?,?,?,?)";
        Object[] arr = new Object[]{
                action.getAname(), action.getAdate(), action.getAday(), action.getAbus(),
                action.getAcount(), action.getAprice(), action.getAcost()
        };
        queryRunner.update(sql, arr);
    }

    public List<Action> getAllActions() throws SQLException {
        String sql = "SELECT * FROM actions";
        List<Action> actions = queryRunner.query(sql, new BeanListHandler<>(Action.class));
        return actions;
    }

    public List<Action> findAction(String aid) throws SQLException {
        String sql = "SELECT * FROM actions WHERE aid = ?";
        List<Action> actionList = queryRunner.query(sql, new BeanListHandler<>(Action.class), aid);
        return actionList;
    }

    public void updateAction(Action action) throws SQLException {
        String sql = "UPDATE actions SET aname=?,adate=?,aday=?,abus=?,aprice=?,acost=? WHERE aid=?";
        Object[] arr = new Object[]{
                action.getAname(), action.getAdate(), action.getAday(), action.getAbus(),
                action.getAprice(), action.getAcost(), action.getAid()
        };
        queryRunner.update(sql, arr);
    }
}
