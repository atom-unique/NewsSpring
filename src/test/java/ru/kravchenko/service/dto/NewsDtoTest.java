package ru.kravchenko.service.dto;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.model.Comment;
import ru.kravchenko.model.Tag;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class NewsDtoTest {

    @Autowired
    private NewsDto newsDto;

    @Autowired
    private List<Comment> commentList;

    @Test
    void getIdTest() {
        Assertions.assertEquals(2L, newsDto.getId());
    }

    @Test
    void setIdTest() {
        newsDto.setId(2L);
        Assertions.assertEquals(2L, newsDto.getId());
    }

    @Test
    void getTitleTest() {
        Assertions.assertNull(newsDto.getTitle());
    }

    @Test
    void setTitleTest() {
        newsDto.setTitle("Title");
        Assertions.assertEquals("Title", newsDto.getTitle());
    }

    @Test
    void getAuthorTest() {
        Assertions.assertNull(newsDto.getAuthor());
    }

    @Test
    void setAuthorTest() {
        newsDto.setAuthor("Author");
        Assertions.assertEquals("Author", newsDto.getAuthor());
    }

    @Test
    void getDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        newsDto.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, newsDto.getDateTime());
    }

    @Test
    void setDateTimeTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        newsDto.setDateTime(dateTime);
        Assertions.assertEquals(dateTime, newsDto.getDateTime());
    }

    @Test
    void getTextTest() {
        Assertions.assertEquals("Text", newsDto.getText());
    }

    @Test
    void setTextTest() {
        newsDto.setText("Text");
        Assertions.assertEquals("Text", newsDto.getText());
    }

    @Test
    void getCommentListTest() {
        Assertions.assertEquals(new ArrayList<>(), newsDto.getCommentList());
    }

    @Test
    void setCommentListTest() {
        newsDto.setCommentList(commentList);
        Assertions.assertEquals(commentList, newsDto.getCommentList());
    }

    @Test
    void getTagListTest() {
        Assertions.assertEquals(new ArrayList<>(), newsDto.getTagList());
    }

    @Test
    void setTagListTest() {
        List<Tag> tagList = Arrays.asList(new Tag(), new Tag());
        newsDto.setTagList(tagList);
        Assertions.assertEquals(tagList, newsDto.getTagList());
    }
}