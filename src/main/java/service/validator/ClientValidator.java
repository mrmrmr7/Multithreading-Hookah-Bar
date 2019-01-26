package service.validator;

import entity.Client;

import java.util.List;

public class ClientValidator {
    public boolean validate(List<Client> clientList) {
        for (Client client : clientList) {
            if (client.getName().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean validate(Client client) {
        return !client.getName().isEmpty();
    }
}
