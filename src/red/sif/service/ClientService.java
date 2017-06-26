package red.sif.service;

import red.sif.beans.Client;
import red.sif.dao.ClientDAO;

import java.sql.SQLException;

/**
 * Created by XIAN. Yingda on 2017/6/26 16:31.
 */
public class ClientService {
    ClientDAO clientDAO = new ClientDAO();
    Rosemary rosemary = new Rosemary();

    public long addClient(Client client) throws SQLException {
        client = rosemary.add(client);
        long addClientKey = clientDAO.addClient(client);
        return addClientKey;
    }
}
