package com.zzx.springbootrabbitmq.component;

import com.zzx.springbootrabbitmq.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * direct 模式发送
     */
    public void send() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        rabbitTemplate.convertAndSend("queue", user);
    }
    // ------------------------------------------------------

    /**
     * work 模式
     */
    public void workSend() {
        List<User> users = Arrays.asList(new User("张三", "123456"),
                new User("李四", "123456"),
                new User("王五", "123456"));
        users.forEach(one -> rabbitTemplate.convertAndSend("workQueue", one));
    }

    /**
     * routing 模式
     */
    public void routingSend() {
        rabbitTemplate.convertAndSend("directExchange", "orange", new User("张三", "123456"));

        rabbitTemplate.convertAndSend("directExchange", "black", new User("李四", "123456"));
        rabbitTemplate.convertAndSend("directExchange", "green", new User("王五", "123456"));
    }

    /**
     * Fanout模式进行发送消息
     */
    public void sendFanoutMessage() {
        template.convertAndSend("fanoutExchange", "", "hello, this is fanoutExchange ");
    }
}
