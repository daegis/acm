package red.sif.dao;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import red.sif.beans.Client;
import red.sif.beans.ClientUpdateBean;
import red.sif.utils.DatabaseUtil;

import java.sql.SQLException;

/**
 * Created by XIAN. Yingda on 2017/6/26 16:34.
 */
public class ClientDAO {
    QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getDs());

    public long addClient(Client client) throws SQLException {
        String sql = "INSERT INTO clients VALUES(NULL,?,?,?,?,?,?,?,?)";
        Object[] arr = new Object[]{
                client.getCnickname(), client.getCphone(), client.getCname(), client.getCidnum(),
                client.getClocation(), client.getCage(), client.getCgender(), client.getCnote()
        };
        //insert方法返回当前插入对象的主键值
        long update = queryRunner.insert(sql, new ScalarHandler<>(), arr);
        return update;
    }

    public void doClientUpdate(ClientUpdateBean clientUpdateBean) throws SQLException {
        String sql = "update clients set cnickname=?,cname=?,cphone=?,cidnum=?,clocation=?,cage=?,cgender=?,cnote=? where cid=?";
        Object[] arr = new Object[]{
                clientUpdateBean.getCnickname(), clientUpdateBean.getCname(),
                clientUpdateBean.getCphone(), clientUpdateBean.getCidnum(),
                clientUpdateBean.getClocation(), clientUpdateBean.getCage(),
                clientUpdateBean.getCgender(), clientUpdateBean.getCnote(),
                clientUpdateBean.getCid()
        };
        queryRunner.update(sql,arr);
    }
}
