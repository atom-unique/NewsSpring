package ru.kravchenko.controller;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.service.NewsService;
import ru.kravchenko.service.dto.NewsDto;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class NewsControllerTest {

    @Autowired
    private NewsController newsController;

    @Autowired
    @Qualifier("newsServiceMock")
    private NewsService newsService;

    @Test
    void getAllNewsTest() {
        newsController.getAllNews();
        verify(newsService, times(1)).findAllNews();
    }

    @Test
    void getNewsTest() {
        newsController.getNews(1L);
        verify(newsService, times(1)).findById(1L);
    }

    @Test
    void saveNewsTest() {
        NewsDto newsDto = new NewsDto();
        newsController.saveNews(newsDto);
        verify(newsService, times(1)).saveNews(newsDto);
    }

    @Test
    void updateNewsTest() {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(1L);
        newsController.updateNews(1L, newsDto);
        verify(newsService, times(1)).updateNews(1L, newsDto);
    }

    @Test
    void deleteNewsTest() {
        newsController.deleteNews(1L);
        verify(newsService, times(1)).removeNews(1L);
    }
}