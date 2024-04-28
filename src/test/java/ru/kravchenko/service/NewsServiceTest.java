package ru.kravchenko.service;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.service.dto.NewsDto;
import ru.kravchenko.service.exception.EntityNotFoundException;

import java.util.ArrayList;

import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsDto newsDto;

    @Test
    void findByIdTest() {
        Assertions.assertEquals(1L, newsService.findById(1L).getId());
    }

    @Test
    void findByIdNotFountTest() {
        try {
            newsService.findById(2L);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 2"));
        }
    }

    @Test
    void findAllNewsTest() {
        Assertions.assertEquals(new ArrayList<>(), newsService.findAllNews());
    }

    @Test
    void saveNewsTest() {
        try {
            newsService.saveNews(new NewsDto());
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 2"));
        }
    }

    @Test
    void removeNewsTest() {
        try {
            newsService.removeNews(3L);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 3"));
        }
    }

    @Test
    void updateNewsTest() {
        try {
            newsService.updateNews(5L, newsDto);
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("Entity not found by parameter: 5"));
        }
    }
}