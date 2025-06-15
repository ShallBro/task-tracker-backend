package org.example.task_tracker_backend.dto;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class TaskDTO {
  private String title;
  private String description;
  private Boolean isDone;
  private Timestamp createdAt;
  private Timestamp doneAt;
}
