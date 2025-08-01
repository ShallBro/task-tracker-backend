package org.example.task_tracker_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailTaskDTO {
    private String to;
    private String subject;
    private String body;
}
