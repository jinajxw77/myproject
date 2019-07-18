package com.jixw.cboot.mq.controller.demo;

import com.alibaba.fastjson.JSON;
//import com.springboot.rocketmq.content.UserContent;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 18011618
 * @Date 10:31 2018/7/18
 * @Function 模拟用户消息发送
 */
@Component
public class UserProducer {
    /**
     * 生产者的组名
     */
    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String producerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @PostConstruct
    public void produder() {
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                /*UserContent userContent = new UserContent(String.valueOf(i),"abc"+i);
                String jsonstr = JSON.toJSONString(userContent);*/
                Map<String,String> map = new HashMap<String,String>();
                map.put("username","jixw"+i);
                map.put("pwd","123"+i);
                String jsonstr = JSON.toJSONString(map);
                System.out.println("发送消息:"+jsonstr);
                Message message = new Message("user-topic", "user-tag", jsonstr.getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult result = producer.send(message);
                System.err.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}