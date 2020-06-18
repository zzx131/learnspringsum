package com.zzx.springbootrabbitmq.component;

import com.zzx.springbootrabbitmq.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void topicSend() {
        rabbitTemplate.convertAndSend("topicExchange", "a.stu.gg", new User("张三", "12345"));

        rabbitTemplate.convertAndSend("topicExchange", "b.schoo.hh", new User("李四", "123456"));
        rabbitTemplate.convertAndSend("topicExchange", "c.schoo.mm", new User("王五", "123456"));
    }
}
