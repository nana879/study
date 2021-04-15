package com.junit5.demo;

import com.utils.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author nana
 * @date 2021/4/12
 */
public class AssetAllDemo {
    @Test
    void addTest() throws InterruptedException {
        int result = Calculator.add(4,2);
        System.out.println("计算结果==" + result);

        int result01 = Calculator.add(0,1);
        System.out.println("计算结果==" + result01);

        int result02 = Calculator.add(3,2);
        System.out.println("计算结果==" + result02);

        assertAll("计算结果检验",
                ()->{assertEquals(6,result);
                System.out.println("111111");
                },
                ()->assertEquals(2,result01),
                ()->assertEquals(4,result02)
        );
    }

    @Test
    void addTest02() throws InterruptedException {
        List<Executable> assetList = new ArrayList<>();
        int result = Calculator.add(4,2);
        System.out.println("计算结果==" + result);
        assetList.add(()->assertEquals(6,result));

        int result01 = Calculator.add(0,1);
        System.out.println("计算结果==" + result01);
        assetList.add(()->assertEquals(2,result01));

        int result02 = Calculator.add(3,2);
        System.out.println("计算结果==" + result02);
        assetList.add(()->assertEquals(6,result02));

        assertAll("计算结果检验",assetList.stream());
    }
}
