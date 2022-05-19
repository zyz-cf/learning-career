package com.zyz.spring.core.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 用户类
 *
 * @author 张易筑
 * @date 2022/4/22-13:36 星期五
 */
@Data
public class User {

    private String name;

    private String money;

    @ApiModelProperty(value = "地址")
    private Address address;

    @ApiModelProperty(value = "卡")
    private Map<String, String> cards;

    @ApiModelProperty(value = "爱好")
    private String[] hobbies;

    @ApiModelProperty(value = "书单")
    private List<String> bookList;

    @ApiModelProperty(value = "朋友")
    private Set<String> friends;

    @ApiModelProperty(value = "信息")
    private Properties infos;
}
