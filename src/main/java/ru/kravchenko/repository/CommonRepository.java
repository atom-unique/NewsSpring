package ru.kravchenko.repository;

public interface CommonRepository<M> {

    M findOne(Long id);

    void create(M model);

    void update(M model);

    void remove(Long id);
}
