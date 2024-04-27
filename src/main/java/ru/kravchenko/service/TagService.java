package ru.kravchenko.service;

import ru.kravchenko.service.dto.TagDto;

public interface TagService {

    TagDto findById(Long id);

    void saveTag(TagDto tag);

    void removeTag(Long id);
}
