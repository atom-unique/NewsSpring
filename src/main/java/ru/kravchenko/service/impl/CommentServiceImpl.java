package ru.kravchenko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.Comment;
import ru.kravchenko.repository.CommentRepository;
import ru.kravchenko.service.CommentService;
import ru.kravchenko.service.dto.CommentDto;
import ru.kravchenko.service.exception.EntityNotFoundException;
import ru.kravchenko.service.mapper.CommentMapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto findById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id)
        ));
    }

    @Override
    public List<CommentDto> findAllComment(Long newsId) {
        return convertList(commentRepository.findAll());
    }

    @Override
    @Transactional
    public void saveComment(CommentDto commentDto) {
        commentRepository.save(commentMapper.toModel(commentDto));
    }

    @Override
    @Transactional
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateComment(Long id, CommentDto commentDto) {
        commentDto.setId(id);
        commentRepository.save(commentMapper.toModel(commentDto));
    }

    private List<CommentDto> convertList(List<Comment> commentList) {
        return commentList.isEmpty() ?
                Collections.emptyList() :
                commentList.stream().map(commentMapper::toDto).collect(Collectors.toList());
    }
}
