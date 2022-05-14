package com.company;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.company.Constants.QUEUE;
import static com.company.Constants.QUEUE2;

@Component
public class RabbitConsumer {

    @RabbitListener(queues = QUEUE2)
    public void sysOutSms(SmsDto smsDto){
        System.err.println(smsDto);
    }

}
