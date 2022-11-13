package com.aps.rabbit.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send-message")
public class SenderController {
    @Autowired
    SenderService senderService;

    @GetMapping
    public void send() {
        this.senderService.sendMessage();
    }
}
