package com.example.demo.controller;

import com.example.demo.model.CommunicationMessage;
import com.example.demo.service.CommunicationMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class CommunicationMessageController {

    private final CommunicationMessageService messageService;

    @GetMapping
    public List<CommunicationMessage> getAllMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunicationMessage> getMessageById(@PathVariable Long id) {
        CommunicationMessage message = messageService.getMessageById(id);
        if (message != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CommunicationMessage createMessage(@RequestBody CommunicationMessage message) {
        return messageService.addMessage(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunicationMessage> updateMessage(@PathVariable Long id, @RequestBody CommunicationMessage messageDetails) {
        CommunicationMessage updatedMessage = messageService.updateMessage(messageDetails, id);
        if (updatedMessage != null) {
            return ResponseEntity.ok(updatedMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}
