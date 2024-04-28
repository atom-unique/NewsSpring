package ru.kravchenko.controller;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.service.TagService;
import ru.kravchenko.service.dto.TagDto;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class TagControllerTest {

    @Autowired
    private TagController tagController;

    @Autowired
    @Qualifier("tagServiceMock")
    private TagService tagService;

    @Test
    void getTagTest() {
        tagController.getTag(1L);
        verify(tagService, times(1)).findById(1L);
    }

    @Test
    void saveTagTest() {
        TagDto tagDto = new TagDto();
        tagController.saveTag(tagDto);
        verify(tagService, times(1)).saveTag(tagDto);
    }

    @Test
    void deleteTagTest() {
        tagController.deleteTag(1L);
        verify(tagService, times(1)).removeTag(1L);
    }
}