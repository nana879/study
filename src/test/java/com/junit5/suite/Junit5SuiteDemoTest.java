package com.junit5.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
/**
*套件执行
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({
        "com.junit5.suite.testcase1","com.junit5.suite.testcase2"
})
@IncludePackages({
        "com.junit5.suite.testcase1","com.junit5.suite.testcase2"
})
public class Junit5SuiteDemoTest {

}
