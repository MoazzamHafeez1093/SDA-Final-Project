package com.example.demo.repository;

import com.example.demo.model.CommunicationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationMessageRepository extends JpaRepository<CommunicationMessage, Long> {
}
