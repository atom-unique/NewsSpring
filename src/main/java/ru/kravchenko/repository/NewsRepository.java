package ru.kravchenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
