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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class TagDtoTest {

    @Autowired
    private TagDto tagDto;

    @Autowired
    private List<News> newsList;

    @Test
    void getIdTest() {
        Assertions.assertEquals(3L, tagDto.getId());
    }

    @Test
    void setIdTest() {
        tagDto.setId(3L);
        Assertions.assertEquals(3L, tagDto.getId());
    }

    @Test
    void getNameTest() {
        Assertions.assertEquals("Name", tagDto.getName());
    }

    @Test
    void setNameTest() {
        tagDto.setName("Name");
        Assertions.assertEquals("Name", tagDto.getName());
    }

    @Test
    void getNewsListTest() {
        Assertions.assertEquals(new ArrayList<>(), tagDto.getNewsList());
    }

    @Test
    void setNewsListTest() {
        tagDto.setNewsList(newsList);
        Assertions.assertEquals(newsList, tagDto.getNewsList());
    }
}