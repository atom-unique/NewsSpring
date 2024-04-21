package ru.kravchenko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.Comment;
import ru.kravchenko.repository.CommentRepository;
import ru.kravchenko.service.CommentService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Comment> findAllComment(Long newsId) {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(Long id, Comment comment) {
        comment.setId(id);
        commentRepository.save(comment);
    }
}
