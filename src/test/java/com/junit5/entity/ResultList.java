package com.junit5.entity;

import lombok.Data;

import java.util.List;

/**
 * @describe 结果列表
 * @Author nana
 * @date 2021/4/12
 */
@Data
public class ResultList {
        private List<ShellResult> resultList;
}
