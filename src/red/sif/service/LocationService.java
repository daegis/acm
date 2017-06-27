package red.sif.service;

import red.sif.beans.Location;
import red.sif.dao.LocationDAO;

import java.sql.SQLException;

/**
 * Created by XIAN. Yingda on 2017/6/27 21:34.
 */
public class LocationService {
    LocationDAO locationDAO = new LocationDAO();

    public String findLocation(String loc) throws SQLException {
        Location location = locationDAO.findLocation(loc);
        if (location != null) {
            return location.toString();
        }
        loc = loc.substring(0, 4) + "%";
        location = locationDAO.findBlurLocation(loc);
        if (location != null) {
            return location.toString();
        }
        loc = loc.substring(0, 2) + "%";
        location = locationDAO.findBlurProvinceLocation(loc);
        if (location != null) {
            return location.toString();
        }
        return "原有身份证所在地由于撤县设市等原因未能查到,请手动修改地址";
    }
}
