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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class NewsTest {

    @Autowired
    private News news;

    @Autowired
    private List<Comment> commentList;

    @Test
    void getIdTest() {
        Assertions.assertEquals(2L, news.getId());
    }

    @Test
    void setIdTest() {
        news.setId(2L);
        Assertions.assertEquals(2L, news.getId());
    }

    @Test
    void getTitleTest() {
        Assertions.assertNull(news.getTitle());
    }

    @Test
    void setTitleTest() {
        news.setTitle("Title");
        Assertions.assertEquals("Title", news.getTitle());
    }

    @Test
    void getAuthorTest() {
        Assertions.assertNull(news.getAuthor());
    }

    @Test
    void setAuthorTest() {
        news.setAuthor("Author");
        Assertions.assertEquals("Author", news.getAuthor());
    }

    @Test
    void getDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        news.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, news.getDateTime());
    }

    @Test
    void setDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        news.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, news.getDateTime());
    }

    @Test
    void getTextTest() {
        Assertions.assertEquals("Text", news.getText());
    }

    @Test
    void setTextTest() {
        news.setText("Text");
        Assertions.assertEquals("Text", news.getText());
    }

    @Test
    void getCommentListTest() {
        Assertions.assertEquals(new ArrayList<>(), news.getCommentList());
    }

    @Test
    void setCommentListTest() {
        news.setCommentList(commentList);
        Assertions.assertEquals(commentList, news.getCommentList());
    }

    @Test
    void getTagListTest() {
        Assertions.assertEquals(new ArrayList<>(), news.getTagList());
    }

    @Test
    void setTagListTest() {
        List<Tag> tagList = Arrays.asList(new Tag(), new Tag());
        news.setTagList(tagList);
        Assertions.assertEquals(tagList, news.getTagList());
    }
}