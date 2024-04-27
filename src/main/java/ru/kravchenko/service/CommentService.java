package ru.kravchenko.service;

import ru.kravchenko.service.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto findById(Long id);

    List<CommentDto> findAllComment(Long newsId);

    void saveComment(CommentDto commentDto);

    void removeComment(Long id);

    void updateComment(Long id, CommentDto commentDto);
}
