package ru.kravchenko.service;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.service.dto.TagDto;
import ru.kravchenko.service.exception.EntityNotFoundException;

import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Test
    void findByIdTest() {
        Assertions.assertEquals(1L, tagService.findById(1L).getId());
    }

    @Test
    void findByIdNotFountTest() {
        try {
            tagService.findById(2L);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 2"));
        }
    }

    @Test
    void saveTagTest() {
        try {
            tagService.saveTag(new TagDto());
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 2"));
        }
    }

    @Test
    void removeTagTest() {
        try {
            tagService.removeTag(3L);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 3"));
        }
    }
}