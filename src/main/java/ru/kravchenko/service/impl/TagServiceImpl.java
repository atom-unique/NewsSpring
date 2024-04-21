package ru.kravchenko.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.model.Tag;
import ru.kravchenko.repository.TagRepository;
import ru.kravchenko.repository.impl.TagRepositoryImpl;
import ru.kravchenko.service.TagService;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(SessionFactory sessionFactory) {
        this.tagRepository = new TagRepositoryImpl(sessionFactory);
    }

    @Override
    public Tag findById(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public void saveTag(Tag tag) {
        tagRepository.create(tag);
    }

    @Override
    public void removeTag(Long id) {
        tagRepository.remove(id);
    }
}
