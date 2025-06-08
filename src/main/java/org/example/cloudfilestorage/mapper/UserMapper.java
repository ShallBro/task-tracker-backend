package org.example.cloudfilestorage.mapper;

import org.example.cloudfilestorage.dto.UserDTO;
import org.example.cloudfilestorage.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDTO, User> {

  @Override
  @Mapping(target = "email", source = "user.email")
  @Mapping(target = "password", source = "user.password")
  UserDTO toDto(User user);
}
