package com.zyz.springboot.kafka.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 订单类
 *
 * @author 张易筑
 * @date 2023-11-03 16:17:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Order对象", description = "订单类")
public class Order {

    @ApiModelProperty(value = "订单id")
    private long orderId;

    @ApiModelProperty(value = "订单号")
    private String orderNum;

    @ApiModelProperty(value = "订单创建时间")
    private LocalDateTime createTime;
}
