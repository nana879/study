package com.junit5.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

public class YamlDemo {
    @ParameterizedTest
    @MethodSource("testParamJson")
    void testParamYaml(User user){
        Assertions.assertTrue(user.name.length()>3);
    }

    static List<User> testParamYaml() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<User>>(){};
        List<User> users = mapper.readValue(YamlDemo.class.getResourceAsStream("/user.yaml"),typeReference);
        return users;
    }

    static List<User> testParamJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference typeReference = new TypeReference<List<User>>(){};
        List<User> users = mapper.readValue(YamlDemo.class.getResourceAsStream("/user.json"),typeReference);
        return users;
    }


}
