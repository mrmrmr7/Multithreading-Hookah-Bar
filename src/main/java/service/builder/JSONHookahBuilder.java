package service.builder;

import com.google.gson.Gson;
import entity.Hookah;
import service.validator.HookahValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONHookahBuilder {
    public List<Hookah> build(String JSONPath) throws InvalidHookahException, IOException {
        Gson gson = new Gson();
        String content = "";

        content = new String(Files.readAllBytes(Paths.get(JSONPath)));

        List<Hookah> hookahList = new ArrayList<>();

        HookahValidator validator = new HookahValidator();

        if (!validator.validate(hookahList)) {
            throw new InvalidHookahException("Hookah list contain error");
        }

        return hookahList;
    }
}
