package ru.kravchenko.service;

import ru.kravchenko.model.News;

import java.util.List;

public interface NewsService {

    News findById(Long id);

    List<News> findAllNews();

    void saveNews(News news);

    void removeNews(Long id);
}
