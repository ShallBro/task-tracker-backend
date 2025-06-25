package org.example.task_tracker_backend.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

import static org.example.task_tracker_backend.constants.ControllerAdviceConstant.EMAIL_SENDING_TASKS;

public class KafkaConfiguration {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic(EMAIL_SENDING_TASKS, 1, (short) 1);
    }
}
