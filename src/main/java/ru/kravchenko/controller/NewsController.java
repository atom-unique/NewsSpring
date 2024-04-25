package ru.kravchenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.model.News;
import ru.kravchenko.service.NewsService;

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
    public List<News> getAllNews() {
        return newsService.findAllNews();
    }

    @GetMapping("/news")
    public News getNews(@RequestParam(name = "id") Long id) {
        return newsService.findById(id);
    }

    @PostMapping("/news")
    public void saveNews(@RequestBody News news) {
        newsService.saveNews(news);
    }

    @PostMapping("/news/update")
    public void updateNews(@RequestParam(name = "id") Long id,
                           @RequestBody News news) {
        newsService.updateNews(id, news);
    }

    @DeleteMapping("/news")
    public void deleteNews(@RequestParam(name = "id") Long id) {
        newsService.removeNews(id);
    }
}
