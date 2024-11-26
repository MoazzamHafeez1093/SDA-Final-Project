package com.example.demo.service;

import com.example.demo.model.CommunicationMessage;
import java.util.List;

public interface ICommunicationMessageService {
    List<CommunicationMessage> getMessages();

    CommunicationMessage addMessage(CommunicationMessage message);

    CommunicationMessage getMessageById(Long id);

    CommunicationMessage updateMessage(CommunicationMessage message, Long id);

    void deleteMessage(Long id);
}
