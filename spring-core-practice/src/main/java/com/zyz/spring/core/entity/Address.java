package com.zyz.spring.core.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张易筑
 * @date 2022/4/22-13:40 星期五
 */
@Data
public class Address {

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String district;

    @ApiModelProperty(value = "街道")
    private String street;

    @ApiModelProperty(value = "详细地址")
    private String detail;

    @ApiModelProperty(value = "邮编")
    private String zipCode;
}
