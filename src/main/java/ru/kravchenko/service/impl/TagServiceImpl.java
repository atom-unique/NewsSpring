package ru.kravchenko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.Tag;
import ru.kravchenko.repository.TagRepository;
import ru.kravchenko.service.TagService;

@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public Tag findById(Long id) {
        return tagRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    @Transactional
    public void removeTag(Long id) {
        tagRepository.deleteById(id);
    }
}
