package com.example.tradingengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public void sendOrder(String msgId, String msg){
        kafkaTemplate.send("msg", msgId, msg);
    }

//    @PostMapping
//    public void sendMsg(String msgId, String msg){
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("msg", msgId, msg);
//        future.addCallback(System.out::println, System.err::println);
//        kafkaTemplate.flush();
//    }
}