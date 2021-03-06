package red.sif.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import red.sif.beans.ActionClient;
import red.sif.beans.Client;
import red.sif.beans.ClientUpdateBean;
import red.sif.utils.DatabaseUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/26 16:35.
 */
public class ACDAO {
    QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getDs());


    public int getClientCountInAction(String joint) throws SQLException {
        String sql = "SELECT count(*) FROM acjoin WHERE aid=?";
        long query = queryRunner.query(sql, new ScalarHandler<>(), joint);
        return (int) query;
    }

    public void acjoin(String joint, long addedClientKey, int i, String sdf, int i1, int i2, int i3, String status, boolean b) throws SQLException {
        String sql = "INSERT INTO acjoin VALUES(?,?,?,?,?,?,?,?,?)";
        Object[] arr = new Object[]{joint, addedClientKey, i, sdf, i1, i2, i3, status, b};
        queryRunner.update(sql, arr);
    }

    public List<ActionClient> getClientsInAction(String aid) throws SQLException {
        String sql = "SELECT clients.cid,cnickname,cname,cphone,cidnum,clocation,cage,cgender,acorder,acdate,acprice,acdiscount,acprecharge,acpremethod,acisready FROM clients,acjoin WHERE clients.cid=acjoin.cid AND aid=?;";
        List<ActionClient> actionClientList = queryRunner.query(sql, new BeanListHandler<>(ActionClient.class), aid);
        return actionClientList;
    }

    public ActionClient getProperClientInAction(String aid, String cid) throws SQLException {
        String sql = "SELECT clients.cid,cnickname,cname,cphone,cidnum,clocation,cage,cgender,cnote,acorder,acdate,acprice,acdiscount,acprecharge,acpremethod,acisready FROM clients,acjoin WHERE clients.cid=acjoin.cid AND aid=? AND clients.cid=?";
        List<ActionClient> actionClientList = queryRunner.query(sql, new BeanListHandler<>(ActionClient.class), aid, cid);
        if (actionClientList == null || actionClientList.size() == 0) {
            return null;
        } else {
            return actionClientList.get(0);
        }
    }

    public void doClientUpdate(ClientUpdateBean clientUpdateBean) throws SQLException {
        String sql = "UPDATE acjoin SET acdiscount=?,acprecharge=?,acpremethod=? WHERE aid=? AND cid=?";
        Object[] arr = new Object[]{
                clientUpdateBean.getAcdiscount(), clientUpdateBean.getAcprecharge(),
                clientUpdateBean.getAcpremethod(), clientUpdateBean.getAid(), clientUpdateBean.getCid()
        };
        queryRunner.update(sql, arr);
    }
}
