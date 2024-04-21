package ru.kravchenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
