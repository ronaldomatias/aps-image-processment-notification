package com.aps.rabbit.sender;

import com.aps.rabbit.util.ObjectMapperUtil;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {
    private final String EXCHANGE = "notification";
    private final String ROUTING_KEY = "gun";
    private final String MESSAGE = "A câmera identificou um indivíduo armado na sua casa.";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(SenderController.ImagePathDTO dto) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, this.writeValueAsString(new MessageDTO(MESSAGE, dto)));
    }

    @SneakyThrows
    private String writeValueAsString(Object object) {
        return ObjectMapperUtil.getMapper().writeValueAsString(object);
    }

    @lombok.Data
    @lombok.AllArgsConstructor
    public static class MessageDTO {
        private String message;
        private SenderController.ImagePathDTO imagePath;
    }
}
