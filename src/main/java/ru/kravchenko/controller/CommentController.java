package ru.kravchenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.service.CommentService;
import ru.kravchenko.service.dto.CommentDto;

import java.util.List;

@RestController
@RequestMapping("api/news/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDto> getAllComments(@RequestParam(name = "news_id") Long newsId) {
        return commentService.findAllComment(newsId);
    }

    @GetMapping("/comment")
    public CommentDto getComment(@RequestParam(name = "id") Long id) {
        return commentService.findById(id);
    }

    @PostMapping("/comment")
    public void saveComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto);
    }

    @PostMapping("/comment/update")
    public void updateComment(@RequestParam(name = "id") Long id,
                              @RequestBody CommentDto commentDto) {
        commentService.updateComment(id, commentDto);
    }

    @DeleteMapping("/comment")
    public void deleteComment(@RequestParam(name = "id") Long id) {
        commentService.removeComment(id);
    }
}
