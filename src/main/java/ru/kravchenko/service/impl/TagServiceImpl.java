package ru.kravchenko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.repository.TagRepository;
import ru.kravchenko.service.TagService;
import ru.kravchenko.service.dto.TagDto;
import ru.kravchenko.service.exception.EntityNotFoundException;
import ru.kravchenko.service.mapper.TagMapper;

@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public TagDto findById(Long id) {
        return tagMapper.toDto(tagRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id)
        ));
    }

    @Override
    @Transactional
    public void saveTag(TagDto tagDto) {
        tagRepository.save(tagMapper.toModel(tagDto));
    }

    @Override
    @Transactional
    public void removeTag(Long id) {
        tagRepository.deleteById(id);
    }
}
