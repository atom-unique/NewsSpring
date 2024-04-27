package ru.kravchenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.service.NewsService;
import ru.kravchenko.service.dto.NewsDto;

import java.util.List;

@RestController
@RequestMapping("api/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsDto> getAllNews() {
        return newsService.findAllNews();
    }

    @GetMapping("/news")
    public NewsDto getNews(@RequestParam(name = "id") Long id) {
        return newsService.findById(id);
    }

    @PostMapping("/news")
    public void saveNews(@RequestBody NewsDto newsDto) {
        newsService.saveNews(newsDto);
    }

    @PostMapping("/news/update")
    public void updateNews(@RequestParam(name = "id") Long id,
                           @RequestBody NewsDto newsDto) {
        newsService.updateNews(id, newsDto);
    }

    @DeleteMapping("/news")
    public void deleteNews(@RequestParam(name = "id") Long id) {
        newsService.removeNews(id);
    }
}
