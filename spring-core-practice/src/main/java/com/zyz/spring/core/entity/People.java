package com.zyz.spring.core.entity;

import lombok.Data;

/**
 * 人
 *
 * @author 张易筑
 * @date 2022/4/25-11:08 星期一
 */
@Data
public class People {

    private String name;

    private Cat cat;

    private Dog dog;
}
