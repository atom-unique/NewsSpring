package ru.kravchenko.service.mapper;

import org.mapstruct.Mapper;
import ru.kravchenko.model.Tag;
import ru.kravchenko.service.dto.TagDto;

@Mapper(uses = NewsMapper.class, componentModel = "spring")
public interface TagMapper {

    Tag toModel(TagDto dto);

    TagDto toDto(Tag model);
}
