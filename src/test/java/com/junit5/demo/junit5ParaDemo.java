package com.junit5.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class junit5ParaDemo {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void testParam(int argument){assertTrue(argument>0&&argument<4);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","   ","\t","\n"})
    void testParamString(String text){
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @MethodSource
    void testParamMethod(String text){
        assertNotNull(text);
    }

    static Stream<String> testParamMethod(){
        return Stream.of("apple","banana","orange");
    }

    @ParameterizedTest
    @MethodSource("testParamMethodSource")
    void testParamMethodSource(String str, int num, List<String> list){
        assertEquals(5,str.length());
        assertEquals(2,list.size());
    }

    static Stream<Arguments> testParamMethodSource(){
        return Stream.of(
                Arguments.of("apple",1, Arrays.asList("a","b")),
                Arguments.of("lemon",2, Arrays.asList("x","y"))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "apple,      1",
            "banana,     2",
            "'lemon, lime', 0xf1"
    })
    void testParamCsvSource(String fruit,int rank){
        assertNotNull(fruit);
        assertNotEquals(0,rank);
    }


    //写路径时别忘记加反斜杠
    @ParameterizedTest
    @CsvFileSource(resources = "/two_column.csv")
    void testParamCsvFileSource(String fruit){
        assertNotNull(fruit);
    }
}
