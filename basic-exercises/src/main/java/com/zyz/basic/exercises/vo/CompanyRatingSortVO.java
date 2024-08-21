package com.zyz.basic.exercises.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 企业评级排名VO
 *
 * @author wanglt
 * @date 2023-04-25 15:58
 **/
@Data
@ApiModel(value = "CompanyRatingSortVO", description = "企业评级排名VO")
public class CompanyRatingSortVO {

    @ApiModelProperty(value = "评级类型")
    private String ratingType;

    @ApiModelProperty(value = "评级")
    private String creditRating;

    @ApiModelProperty(value = "评级日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ratingDt;

    @ApiModelProperty(value = "与白名单中主体对比/排名")
    private String whiteRank;

    @ApiModelProperty(value = "与同省城投平台对比/排名")
    private String provinceRank;

    @ApiModelProperty(value = "与全国所有城投平台对比/排名")
    private String countryRank;

    @ApiModelProperty(value = "同省城投平台总数")
    private String provinceTotal;

    @ApiModelProperty(value = "全国所有城投平台总数")
    private String countryTotal;

    @ApiModelProperty(value = "全国所有城投平台ID列表")
    private List<Long> countryCompanyIds;

    @ApiModelProperty(value = "白名单城投平台总数（对比主体不在白名单则总数+1）")
    private String whitTotal;
}
