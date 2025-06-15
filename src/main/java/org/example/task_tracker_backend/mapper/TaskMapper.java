package org.example.task_tracker_backend.mapper;

import java.util.List;
import org.example.task_tracker_backend.dto.TaskDTO;
import org.example.task_tracker_backend.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper extends GenericMapper<TaskDTO, Task> {

  @Override
  @Mapping(target = "title", source = "task.title")
  @Mapping(target = "description", source = "task.description")
  @Mapping(target = "isDone", source = "task.isDone")
  @Mapping(target = "createdAt", source = "task.createdAt")
  @Mapping(target = "doneAt", source = "task.doneAt")
  TaskDTO toDto(Task task);

  @Override
  List<TaskDTO> toDtoList(List<Task> tasks);
}
