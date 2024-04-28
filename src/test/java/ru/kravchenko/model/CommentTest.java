package ru.kravchenko.model;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class CommentTest {

    @Autowired
    private Comment comment;

    @Autowired
    private News news;

    @Test
    void getIdTest() {
        Assertions.assertEquals(1L, comment.getId());
    }

    @Test
    void setIdTest() {
        comment.setId(1L);
        Assertions.assertEquals(1L, comment.getId());
    }

    @Test
    void getAuthorTest() {
        Assertions.assertNull(comment.getAuthor());
    }

    @Test
    void setAuthorTest() {
        comment.setAuthor("Author");
        Assertions.assertEquals("Author", comment.getAuthor());
    }

    @Test
    void getDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        comment.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, comment.getDateTime());
    }

    @Test
    void setDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        comment.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, comment.getDateTime());
    }

    @Test
    void getTextTest() {
        Assertions.assertEquals("Some text", comment.getText());
    }

    @Test
    void setTextTest() {
        comment.setText("Some text");
        Assertions.assertEquals("Some text", comment.getText());
    }

    @Test
    void getNewsTest() {
        Assertions.assertNotNull(comment.getNews());
    }

    @Test
    void setNewsTest() {
        Assertions.assertNull(comment.getNews());
        comment.setNews(news);
        Assertions.assertNotNull(comment.getNews());
    }
}