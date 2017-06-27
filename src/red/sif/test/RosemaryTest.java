package red.sif.test;

import org.junit.jupiter.api.Test;
import red.sif.beans.ClientUpdateBean;
import red.sif.service.Rosemary;

/**
 * Created by XIAN. Yingda on 2017/6/27 21:07.
 */
public class RosemaryTest {
    @Test
    public void test01() {
        Rosemary rosemary = new Rosemary();
        ClientUpdateBean clientUpdateBean = new ClientUpdateBean();
        clientUpdateBean.setCidnum("150106199111111111");
        rosemary.additionalInformation(clientUpdateBean);
        System.out.println(clientUpdateBean);
    }
}
