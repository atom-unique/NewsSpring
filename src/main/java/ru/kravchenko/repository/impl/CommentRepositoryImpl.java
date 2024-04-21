package ru.kravchenko.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.Comment;
import ru.kravchenko.repository.CommentRepository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    public static final String SELECT_ALL = "select c from Comment c";
    private final SessionFactory sessionFactory;

    @Autowired
    public CommentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Comment findOne(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Comment.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAll(Long newsId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(SELECT_ALL, Comment.class).getResultList();
    }

    @Override
    @Transactional
    public void create(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
    }

    @Override
    @Transactional
    public void update(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        Comment commentToUpdate = session.get(Comment.class, comment.getId());
        commentToUpdate.setNewsId(comment.getNewsId());
        commentToUpdate.setAuthor(comment.getAuthor());
        commentToUpdate.setDateTime(comment.getDateTime());
        commentToUpdate.setText(comment.getText());
        commentToUpdate.setNews(comment.getNews());
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Session.class, id));
    }
}
