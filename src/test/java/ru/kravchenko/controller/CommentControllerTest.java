package ru.kravchenko.controller;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kravchenko.service.CommentService;
import ru.kravchenko.service.dto.CommentDto;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
class CommentControllerTest {

    @Autowired
    private CommentController commentController;

    @Autowired
    @Qualifier("commentServiceMock")
    private CommentService commentService;

    @Test
    void getAllCommentsTest() {
        commentController.getAllComments(1L);
        verify(commentService, times(1)).findAllComment(1L);
    }

    @Test
    void getCommentTest() {
        commentController.getComment(1L);
        verify(commentService, times(1)).findById(1L);
    }

    @Test
    void saveCommentTest() {
        CommentDto commentDto = new CommentDto();
        commentController.saveComment(commentDto);
        verify(commentService, times(1)).saveComment(commentDto);
    }

    @Test
    void updateCommentTest() {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(1L);
        commentController.updateComment(1L, commentDto);
        verify(commentService, times(1)).updateComment(1L, commentDto);
    }

    @Test
    void deleteCommentTest() {
        commentController.deleteComment(1L);
        verify(commentService, times(1)).removeComment(1L);
    }
}