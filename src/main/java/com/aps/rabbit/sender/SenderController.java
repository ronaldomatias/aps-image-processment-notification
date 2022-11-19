package com.aps.rabbit.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class SenderController {
    @Autowired
    SenderService senderService;

    @PostMapping("/send-message")
    public void send(@RequestBody ImagePathAndDateDTO senderDTO) {
        this.senderService.sendNotification(senderDTO);
    }

    @lombok.Data
    @lombok.NoArgsConstructor
    public static class ImagePathAndDateDTO {
        String imagePath;
        String date;
    }
}


