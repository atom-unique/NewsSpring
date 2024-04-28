package ru.kravchenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.service.TagService;
import ru.kravchenko.service.dto.TagDto;

@RestController
@RequestMapping("api/news/tags/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public TagDto getTag(@RequestParam(name = "id") Long id) {
        return tagService.findById(id);
    }

    @PostMapping
    public void saveTag(@RequestBody TagDto tagDto) {
        tagService.saveTag(tagDto);
    }

    @DeleteMapping
    public void deleteTag(@RequestParam(name = "id") Long id) {
        tagService.removeTag(id);
    }
}
