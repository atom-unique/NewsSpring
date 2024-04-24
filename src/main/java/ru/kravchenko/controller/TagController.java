package ru.kravchenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.model.Tag;
import ru.kravchenko.service.TagService;

@RestController
@RequestMapping("api/news/tags/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public Tag getTag(@RequestParam(name = "id") Long id) {
        return tagService.findById(id);
    }

    @PostMapping
    public void saveTag(@RequestBody Tag tag) {
        tagService.saveTag(tag);
    }

    @DeleteMapping
    public void deleteContact(@RequestParam(name = "id") Long id) {
        tagService.removeTag(id);
    }
}
