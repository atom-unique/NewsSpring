package ru.kravchenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.model.Comment;
import ru.kravchenko.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("api/news/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public List<Comment> getAllComments(@RequestParam(name = "news_id") Long newsId) {
        return commentService.findAllComment(newsId);
    }

    @GetMapping("/comment")
    public Comment getComment(@RequestParam(name = "id") Long id) {
        return commentService.findById(id);
    }
}
