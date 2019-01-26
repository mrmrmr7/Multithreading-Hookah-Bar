package com.mrmrmr7.task.service.builder;

import com.google.gson.Gson;
import com.mrmrmr7.task.entity.Client;
import com.mrmrmr7.task.service.validator.ClientValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JSONClientBuilder {
    public List<Client> build(String JSONPath) throws IOException, InvalidClientException {

        Gson gson = new Gson();
        String content = "";

        content = new String(Files.readAllBytes(Paths.get(JSONPath)));

        List<Client> clientList = Arrays.asList(gson.fromJson(content, Client[].class));

        ClientValidator clientValidator = new ClientValidator();

        if (!clientValidator.validate(clientList)) {
            throw new InvalidClientException("Client list has error");
        }

        return clientList;
    }
}