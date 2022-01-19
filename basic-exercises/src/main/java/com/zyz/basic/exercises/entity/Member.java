package com.zyz.basic.exercises.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 成员类
 *
 * @author 张易筑
 * @date 2022/1/19-13:37 星期三
 */
@ApiModel(value = "Member", description = "成员表")
@Data
@AllArgsConstructor
public class Member {

    @ApiModelProperty(value = "成员ID", required = true)
    private Long memberId;

    @ApiModelProperty(value = "成员名", required = true)
    private String memberName;
}
