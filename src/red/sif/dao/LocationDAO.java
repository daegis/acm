package red.sif.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import red.sif.beans.Location;
import red.sif.utils.DatabaseUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by XIAN. Yingda on 2017/6/27 21:16.
 */
public class LocationDAO {
    QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getDs());

    public Location findLocation(String loc) throws SQLException {
        String sql = "SELECT provincename,cityname,districtname FROM idtolocation WHERE districtid=?";
        Location location = queryRunner.query(sql, new BeanHandler<>(Location.class), loc);
        return location;
    }

    public Location findBlurLocation(String loc) throws SQLException {
        String sql = "SELECT provincename,cityname,districtname FROM idtolocation WHERE districtid LIKE ? LIMIT 0,1";
        List<Location> locationList = queryRunner.query(sql, new BeanListHandler<>(Location.class), loc);
        if (locationList != null && locationList.size() != 0) {
            return locationList.get(0);
        }
        return null;
    }

    public Location findBlurProvinceLocation(String loc) throws SQLException {
        String sql = "SELECT provincename,cityname,districtname FROM idtolocation WHERE provinceid LIKE ?";
        Location location = queryRunner.query(sql, new BeanHandler<>(Location.class), loc);
        return location;
    }
}
