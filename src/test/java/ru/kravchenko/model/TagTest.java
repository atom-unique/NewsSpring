package ru.kravchenko.model;

import config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class TagTest {

    @Autowired
    private Tag tag;

    @Autowired
    private List<News> newsList;

    @Test
    void getIdTest() {
        Assertions.assertEquals(3L, tag.getId());
    }

    @Test
    void setIdTest() {
        tag.setId(3L);
        Assertions.assertEquals(3L, tag.getId());
    }

    @Test
    void getNameTest() {
        Assertions.assertEquals("Name", tag.getName());
    }

    @Test
    void setNameTest() {
        tag.setName("Name");
        Assertions.assertEquals("Name", tag.getName());
    }

    @Test
    void getNewsListTest() {
        Assertions.assertEquals(new ArrayList<>(), tag.getNewsList());
    }

    @Test
    void setNewsListTest() {
        tag.setNewsList(newsList);
        Assertions.assertEquals(newsList, tag.getNewsList());
    }
}