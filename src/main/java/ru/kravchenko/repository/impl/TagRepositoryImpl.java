package ru.kravchenko.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.Tag;
import ru.kravchenko.repository.TagRepository;

@Repository
public class TagRepositoryImpl implements TagRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public TagRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Tag findOne(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tag.class, id);
    }

    @Override
    @Transactional
    public void create(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tag);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Tag.class, id));
    }
}
