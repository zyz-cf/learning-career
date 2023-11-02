package com.zyz.basic.exercises.collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 项目风险财务Excel导入VO
 *
 * @author 张易筑
 * @date 2023-10-30 16:30:24
 */
@Data
@ApiModel(value = "RiskFinanceExcelVO", description = "风险财务Excel导入VO")
public class RiskFinanceExcelVO {

    @ApiModelProperty(value = "主要指标")
    private String majorIndex;

    @ApiModelProperty(value = "上年同期数")
    private String lastYearYOY;

    @ApiModelProperty(value = "本期数据")
    private String currentPeriod;

    @ApiModelProperty(value = "变动比率")
    private String changeRatio;

    @ApiModelProperty(value = "变动原因")
    private String changeReason;
}
