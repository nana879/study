package com.junit5.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.junit5.entity.ResultList;
import com.junit5.entity.ShellResult;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * @desc 动态测试,通过工厂方法，批量生产测试用例
 * @Author nana
 * @date 2021/4/12
 */
public class DynamicDemo {
    @TestFactory
    Collection<DynamicTest> dynamicTestCollection(){
        return Arrays.asList(
                dynamicTest("1st dynamic test",()->
                        assertTrue(true)),

                dynamicTest("2nd dynamic test",()->
                        assertTrue(true))
        );
    }

    @TestFactory
    Collection<DynamicTest> dynamicTests() throws IOException {
        List<DynamicTest> dynamicTests = new ArrayList<>();
        //YAML反序列化
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ResultList resultList = objectMapper.readValue(new File("src/main/resources/data/shell_test_result.yaml"), ResultList.class);

        //动态遍历生成测试方法
        for (ShellResult shellResult : resultList.getResultList()){
            dynamicTests.add(dynamicTest(shellResult.getCaseName(),()->
                    assertTrue(shellResult.getResult())));
        }
        return dynamicTests;
    }


}
