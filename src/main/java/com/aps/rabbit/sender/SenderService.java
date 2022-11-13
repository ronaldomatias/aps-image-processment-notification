package com.aps.rabbit.sender;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {
    private String ROUTING_KEY = "gun";
    private String MESSAGE = "A câmera identificou um indivíduo armado na sua casa";
    @Autowired
   private RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        Message message = new Message(MESSAGE.getBytes());
        rabbitTemplate.send(ROUTING_KEY, message);
    }
}
