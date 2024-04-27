package ru.kravchenko.service;

import ru.kravchenko.service.dto.NewsDto;

import java.util.List;

public interface NewsService {

    NewsDto findById(Long id);

    List<NewsDto> findAllNews();

    void saveNews(NewsDto newsDto);

    void removeNews(Long id);

    void updateNews(Long id, NewsDto newsDto);
}
