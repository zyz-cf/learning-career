package com.zyz.basic.exercises.lambda;

/**
 * 支付服务类
 *
 * @author 张易筑
 * @date 2022/1/19-16:59 星期三
 */
@FunctionalInterface
public interface PayService {

    /**
     * 支付
     *
     * @param money dollars
     * @author 张易筑
     * @date 2022-01-19 17:00:21
     */
    void toPay(Long money);
}
