package ru.kravchenko.service.mapper;

import org.mapstruct.Mapper;
import ru.kravchenko.model.Comment;
import ru.kravchenko.service.dto.CommentDto;

@Mapper(uses = NewsMapper.class, componentModel = "spring")
public interface CommentMapper {

    Comment toModel(CommentDto dto);

    CommentDto toDto(Comment model);
}
