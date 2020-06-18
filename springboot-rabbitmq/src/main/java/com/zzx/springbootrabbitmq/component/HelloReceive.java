package com.zzx.springbootrabbitmq.component;

import com.rabbitmq.client.Channel;
import com.zzx.springbootrabbitmq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HelloReceive {

    /**
     * direct
     *
     * @param user
     */
   /* @RabbitListener(queues = "queue")
    public void processC(Channel channel, User user,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("Receive:" + user.toString());
        channel.basicAck(tag,false);
    }*/
    @RabbitListener(queues = "queue")
    public void processC(User user) {
        System.out.println("Receive:" + user.toString());
    }
    //---------------------------------------------------------------------------------------

    /**
     * work 模式
     *
     * @param user
     */
    @RabbitListener(queues = "workQueue")
    public void workProcessA(Channel channel, User user, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("worka");
        channel.basicAck(tag, false);
        System.out.println(user.toString());
    }

    @RabbitListener(queues = "workQueue")
    public void workProcessB(Channel channel, User user, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("workb");
        channel.basicAck(tag, false);
        System.out.println(user.toString());
    }
    // --------------------------------------------------------------------------------------
    // fanout模式

    /**
     * 利用Fanout 接受到的队列消息
     *
     * @param str1
     */
    @RabbitListener(queues = "fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:" + str1);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:" + str);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:" + str);
    }

    // -------------------------------------
    // routing模式
    @RabbitListener(queues = "rqueuea")
    public void routingProcessA(Channel channel, User user, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("rqueuea");
        channel.basicAck(tag, false);
        System.out.println(user.toString());
    }

    @RabbitListener(queues = "rqueueb")
    public void routingProcessB(Channel channel, User user, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("rqueueb");
        channel.basicAck(tag, false);
        System.out.println(user.toString());
    }

    //--------------------------------------
    // topic 模式
    @RabbitListener(queues = "queueTopicA")
    public void process1(Channel channel, User user, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("rqueuea");
        System.out.println(user.toString());
        channel.basicAck(tag, false);
    }

    @RabbitListener(queues = "queueTopicB")
    public void process2(Channel channel, User user, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("rqueueb");
        System.out.println(user.toString());
        channel.basicAck(tag, false);
    }

}
