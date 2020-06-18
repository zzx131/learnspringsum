package com.zzx.springbootrabbitmq.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RoutingConfig {
    // 创建routing队列
    @Bean(name = "rqueuea")
    public Queue rQueueA() {
        return new Queue("rqueuea");
    }

    @Bean(name = "rqueueb")
    public Queue rQueueB() {
        return new Queue("rqueueb");
    }

    // 创建交换机
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    // 将队列绑定到交换机上
    @Bean
    Binding bindingRouExchangeA(@Qualifier("rqueuea") Queue rqueuea, DirectExchange directExchange) {
        return BindingBuilder.bind(rqueuea).to(directExchange).with("orange");
    }

    @Bean
    Binding bindingRouExchangeB(@Qualifier("rqueueb") Queue rqueueb, DirectExchange directExchange) {
        return BindingBuilder.bind(rqueueb).to(directExchange).with("black");
    }

    @Bean
    Binding bindingRouExchangeC(@Qualifier("rqueueb") Queue rqueueb, DirectExchange directExchange) {
        return BindingBuilder.bind(rqueueb).to(directExchange).with("green");
    }


}
