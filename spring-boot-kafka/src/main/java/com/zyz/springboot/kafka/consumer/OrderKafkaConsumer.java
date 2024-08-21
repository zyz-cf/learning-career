package com.zyz.springboot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 订单类Kafka消费者
 *
 * @Author：张易筑
 * @Datetime：2023-11-03 16:10
 */
@Component
@Slf4j
public class OrderKafkaConsumer {

    @KafkaListener(topics = "shopping", groupId = "my-kafka") //这个groupId是在yml中配置的
    public void consumer(String message) {
        log.info("## consumer message: {}", message);
    }
}
