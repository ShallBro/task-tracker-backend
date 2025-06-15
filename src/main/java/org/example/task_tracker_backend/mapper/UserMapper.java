package org.example.task_tracker_backend.mapper;

import org.example.task_tracker_backend.dto.UserDTO;
import org.example.task_tracker_backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDTO, User> {

  @Override
  @Mapping(target = "email", source = "user.email")
  @Mapping(target = "password", source = "user.password")
  UserDTO toDto(User user);
}
