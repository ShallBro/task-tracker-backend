package org.example.cloudfilestorage.mapper;

public interface GenericMapper<DTO, Entity> {
  DTO toDto(Entity entity);
}
