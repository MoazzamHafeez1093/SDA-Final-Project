package com.example.demo.service;

import com.example.demo.model.CommunicationMessage;
import com.example.demo.repository.CommunicationMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunicationMessageService implements ICommunicationMessageService {
    private final CommunicationMessageRepository messageRepository;

    @Override
    public List<CommunicationMessage> getMessages() {
        return messageRepository.findAll();
    }

    @Override
    public CommunicationMessage addMessage(CommunicationMessage message) {
        return messageRepository.save(message);
    }

    @Override
    public CommunicationMessage getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public CommunicationMessage updateMessage(CommunicationMessage message, Long id) {
        Optional<CommunicationMessage> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            CommunicationMessage updatedMessage = existingMessage.get();
            updatedMessage.setMessage(message.getMessage());
            return messageRepository.save(updatedMessage);
        } else {
            return null;
        }
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
