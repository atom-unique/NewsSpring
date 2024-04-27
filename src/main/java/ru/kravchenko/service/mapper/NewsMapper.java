package ru.kravchenko.service.mapper;

import org.mapstruct.Mapper;
import ru.kravchenko.model.News;
import ru.kravchenko.service.dto.NewsDto;

@Mapper(uses = {TagMapper.class, CommentMapper.class}, componentModel = "spring")
public interface NewsMapper {

    News toModel(NewsDto dto);

    NewsDto toDto(News model);
}
