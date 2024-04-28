package ru.kravchenko.service;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.service.dto.CommentDto;
import ru.kravchenko.service.exception.EntityNotFoundException;

import java.util.ArrayList;

import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentDto commentDto;

    @Test
    void findByIdTest() {
        Assertions.assertEquals(1L, commentService.findById(1L).getId());
    }

    @Test
    void findByIdNotFountTest() {
        try {
            commentService.findById(2L);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 2"));
        }
    }

    @Test
    void findAllCommentTest() {
        Assertions.assertEquals(new ArrayList<>(), commentService.findAllComment(1L));
    }

    @Test
    void saveCommentTest() {
        try {
            commentService.saveComment(new CommentDto());
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 2"));
        }
    }

    @Test
    void removeCommentTest() {
        try {
            commentService.removeComment(3L);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 3"));
        }
    }

    @Test
    void updateCommentTest() {
        try {
            commentService.updateComment(5L, commentDto);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 5"));
        }
    }
}