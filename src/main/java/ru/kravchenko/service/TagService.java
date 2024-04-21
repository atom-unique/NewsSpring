package ru.kravchenko.service;

import ru.kravchenko.model.Tag;

public interface TagService {

    Tag findById(Long id);

    void saveTag(Tag tag);

    void removeTag(Long id);
}
