package ru.kravchenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
