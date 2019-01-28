package com.mrmrmr7.task.service.validator;

import com.mrmrmr7.task.entity.SingleClient;

import java.util.List;

public class ClientValidator {
    public boolean validate(List<SingleClient> singleClientList) {
        for (SingleClient singleClient : singleClientList) {
            if (singleClient.getName().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean validate(SingleClient singleClient) {
        return !singleClient.getName().isEmpty();
    }
}
