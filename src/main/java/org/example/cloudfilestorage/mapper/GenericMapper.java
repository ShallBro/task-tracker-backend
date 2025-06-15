package org.example.cloudfilestorage.mapper;

import java.util.List;

public interface GenericMapper<DTO, Entity> {
  DTO toDto(Entity entity);
  List<DTO> toDtoList(List<Entity> entities);
}
