package com.junit5.entity;

import lombok.Data;

/**
 * @describe shell脚本执行结果
 * @Author nana
 * @date 2021/4/12
 */
@Data
public class ShellResult {
    private String caseName;
    private Boolean result;
}
