package ru.kravchenko.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.News;
import ru.kravchenko.repository.NewsRepository;

import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository {

    public static final String SELECT_ALL = "select n from News n";
    private final SessionFactory sessionFactory;

    @Autowired
    public NewsRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public News findOne(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(News.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(SELECT_ALL, News.class).getResultList();
    }

    @Override
    @Transactional
    public void create(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
    }

    @Override
    @Transactional
    public void update(News news) {
        Session session = sessionFactory.getCurrentSession();
        News newsToUpdate = session.get(News.class, news.getId());
        newsToUpdate.setTitle(news.getTitle());
        newsToUpdate.setAuthor(news.getAuthor());
        newsToUpdate.setDateTime(news.getDateTime());
        newsToUpdate.setText(news.getText());
        newsToUpdate.setCommentList(news.getCommentList());
        newsToUpdate.setTagList(news.getTagList());
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(News.class, id));
    }
}
