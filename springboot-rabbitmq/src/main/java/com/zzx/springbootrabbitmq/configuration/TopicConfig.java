package com.zzx.springbootrabbitmq.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TopicConfig {
    // topic 队列
    @Bean(name = "queueTopicA")
    public Queue queueTopicA() {
        return new Queue("queueTopicA");
    }

    @Bean(name = "queueTopicB")
    public Queue queueTopicB() {
        return new Queue("queueTopicB");
    }
    // 创建交换机
    @Bean
    public TopicExchange topicExchange() {
        return  new TopicExchange("topicExchange");
    }

    // 将队列绑定到交换机上
    @Bean
    Binding bindingExchangeTopicA(@Qualifier("queueTopicA") Queue queueTopicA, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicA).to(topicExchange).with("*.stu.*");//*表示一个词,#表示零个或多个词
    }

    @Bean
    Binding bindingExchangeTopicB(@Qualifier("queueTopicB") Queue queueTopicB, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicB).to(topicExchange).with("*.schoo.#");//*表示一个词,#表示零个或多个词
    }

}
