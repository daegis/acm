package red.sif.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * Created by XIAN. Yingda on 2017/6/25 22:05.
 */
public class DatabaseUtil {
    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDs() {
        return ds;
    }
}
