package ru.kravchenko.repository;

import ru.kravchenko.model.Tag;

public interface TagRepository {

    Tag findOne(Long id);

    void create(Tag tag);

    void remove(Long id);
}
