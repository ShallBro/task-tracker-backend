package org.example.cloudfilestorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Task() {}

  public Task(User user, String title, String description, Boolean isDone, Timestamp createdAt, Timestamp doneAt) {
    this.user = user;
    this.title = title;
    this.description = description;
    this.isDone = isDone;
    this.createdAt = createdAt;
    this.doneAt = doneAt;
  }

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  private String title;

  private String description;

  @Column(name = "is_done")
  private Boolean isDone;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "done_at")
  private Timestamp doneAt;
}
