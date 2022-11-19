package com.aps.rabbit.sender;

import com.aps.rabbit.sender.SenderController.ImagePathAndDateDTO;
import com.aps.rabbit.util.ObjectMapperUtil;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendNotification(ImagePathAndDateDTO imagePath) {
        final String MENSAGEM = String.format("A câmera %s, identificou um indivíduo armado na sua casa.", 1);
        rabbitTemplate.convertAndSend("notification", "gun", this.writeValueAsString(new NotificationDTO(MENSAGEM, imagePath)));
    }

    @SneakyThrows
    private String writeValueAsString(Object object) {
        return ObjectMapperUtil.getMapper().writeValueAsString(object);
    }

    @lombok.Data
    @lombok.AllArgsConstructor
    public static class NotificationDTO {
        private String message;
        private ImagePathAndDateDTO imagePath;
    }
}
