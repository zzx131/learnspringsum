package com.zzx.springbootrabbitmq.controller;

import com.zzx.springbootrabbitmq.component.HelloReceive;
import com.zzx.springbootrabbitmq.component.HelloSender;
import com.zzx.springbootrabbitmq.component.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private TopicSender topicSender;

    /**
     * 发送消息- direct模式
     *
     * @return
     */
    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    public String hello() {
        helloSender.send();
        return "hello";
    }

    /**
     * 发送消息- work模式
     */
    @RequestMapping(value = "/workSend", method = RequestMethod.GET)
    public void workSend() {
        helloSender.workSend();
    }

    @RequestMapping(value = "/routingSend", method = RequestMethod.GET)
    public void routingSend() {
        helloSender.routingSend();
    }

    /**
     * 发送消息- topic模式
     *
     * @return
     */
    @GetMapping(value = "/topicSendMsg")
    public String msg() {
        topicSender.topicSend();
        return "hello";
    }

    /**
     * 利用广播式 发送消息
     *
     * @return
     */
    @GetMapping(value = "/fanout")
    public String fanout() {
        helloSender.sendFanoutMessage();
        return "hello";
    }
}
