package ru.kravchenko.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.model.Comment;
import ru.kravchenko.repository.CommentRepository;
import ru.kravchenko.repository.impl.CommentRepositoryImpl;
import ru.kravchenko.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(SessionFactory sessionFactory) {
        this.commentRepository = new CommentRepositoryImpl(sessionFactory);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public List<Comment> findAllComment(Long newsId) {
        List<Comment> commentList = commentRepository.findAll(newsId);
        return commentList.isEmpty() ? List.of() : commentList;
    }

    @Override
    public void saveComment(Comment comment) {
        if (commentRepository.findOne(comment.getId()) != null && comment.getId() != null) {
            commentRepository.update(comment);
        } else {
            commentRepository.create(comment);
        }
    }

    @Override
    public void removeComment(Long id) {
        commentRepository.remove(id);
    }
}
