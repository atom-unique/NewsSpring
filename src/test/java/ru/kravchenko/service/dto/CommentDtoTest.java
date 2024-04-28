package ru.kravchenko.service.dto;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.model.News;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class CommentDtoTest {

    @Autowired
    private CommentDto commentDto;

    @Autowired
    private News news;

    @Test
    void getIdTest() {
        Assertions.assertEquals(1L, commentDto.getId());
    }

    @Test
    void setIdTest() {
        commentDto.setId(1L);
        Assertions.assertEquals(1L, commentDto.getId());
    }

    @Test
    void getAuthorTest() {
        Assertions.assertNull(commentDto.getAuthor());
    }

    @Test
    void setAuthorTest() {
        commentDto.setAuthor("Author");
        Assertions.assertEquals("Author", commentDto.getAuthor());
    }

    @Test
    void getDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        commentDto.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, commentDto.getDateTime());
    }

    @Test
    void setDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        commentDto.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, commentDto.getDateTime());
    }

    @Test
    void getTextTest() {
        Assertions.assertEquals("Some text", commentDto.getText());
    }

    @Test
    void setTextTest() {
        commentDto.setText("Some text");
        Assertions.assertEquals("Some text", commentDto.getText());
    }

    @Test
    void getNewsTest() {
        Assertions.assertNotNull(commentDto.getNews());
    }

    @Test
    void setNewsTest() {
        Assertions.assertNull(commentDto.getNews());
        commentDto.setNews(news);
        Assertions.assertNotNull(commentDto.getNews());
    }
}