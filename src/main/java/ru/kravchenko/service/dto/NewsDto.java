package ru.kravchenko.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.kravchenko.model.Comment;
import ru.kravchenko.model.Tag;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime dateTime;
    private String text;
    private List<Comment> commentList;
    private List<Tag> tagList;


    public NewsDto() {
        this.commentList = new ArrayList<>();
        this.tagList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
