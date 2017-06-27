package red.sif.service;

import red.sif.beans.Client;
import red.sif.beans.ClientUpdateBean;
import red.sif.beans.Location;
import red.sif.dao.LocationDAO;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XIAN. Yingda on 2017/6/26 16:43.
 */
public class Rosemary {
    public Client add(Client client) {
        client.setCname(client.getCnickname());
        client.setCidnum("0");
        client.setClocation("填写身份证号自动生成");
        client.setCgender("填写身份证号自动生成");
        return client;
    }

    public void additionalInformation(ClientUpdateBean clientUpdateBean) {
        String cidnum = clientUpdateBean.getCidnum();
        if (cidnum.equals("0") || cidnum.length() != 18) {
            return;
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String thisYear = date.substring(0, 4);
        String dob = cidnum.substring(6, 10);
        int age = Integer.parseInt(thisYear) - Integer.parseInt(dob);
        clientUpdateBean.setCage(age + "");
        int i = cidnum.charAt(16) - '0';
        if (i % 2 == 0) {
            clientUpdateBean.setCgender("女");
        } else {
            clientUpdateBean.setCgender("男");
        }
        String loc = cidnum.substring(0, 6);
        LocationService locationService = new LocationService();
        String location = null;
        try {
            location = locationService.findLocation(loc);
        } catch (SQLException e) {
            location = "原有身份证所在地由于撤县设市等原因未能查到,请手动修改地址";
        }
        clientUpdateBean.setClocation(location);
    }
}
