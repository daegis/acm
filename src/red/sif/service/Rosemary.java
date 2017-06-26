package red.sif.service;

import red.sif.beans.Client;

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
}
