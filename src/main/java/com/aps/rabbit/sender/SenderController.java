package com.aps.rabbit.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SenderController {
    @Autowired
    SenderService senderService;

    @PostMapping("/send-message")
    public void send(@RequestBody ImagePathDTO senderDTO) {
        this.senderService.sendMessage(senderDTO);
    }

    @lombok.Data
    @lombok.NoArgsConstructor
    public static class ImagePathDTO {
        String imagePath;
    }
}


