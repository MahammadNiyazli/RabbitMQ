package com.company;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.company.Constants.*;


@RestController
@RequestMapping("/smsSender")
public class RabbitPublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestBody SmsDto smsDto){
        rabbitTemplate.convertAndSend(EXCHANGE2,ROUTING_KEY2, smsDto);
        return ResponseEntity.ok("Successfully published");
    }

}
