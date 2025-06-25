package org.example.task_tracker_backend.service;

import lombok.RequiredArgsConstructor;
import org.example.task_tracker_backend.dto.EmailTaskDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.example.task_tracker_backend.constants.ControllerAdviceConstant.EMAIL_SENDING_TASKS;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, EmailTaskDTO> kafkaTemplate;

    public void sendEmailService(EmailTaskDTO emailTaskDTO) {
        kafkaTemplate.send(EMAIL_SENDING_TASKS, emailTaskDTO);
    }
}
