package ru.kravchenko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.News;
import ru.kravchenko.repository.NewsRepository;
import ru.kravchenko.service.NewsService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<News> findAllNews() {
        return newsRepository.findAll();
    }

    @Transactional
    @Override
    public void saveNews(News news) {
        newsRepository.save(news);
    }

    @Transactional
    @Override
    public void removeNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateNews(Long id, News news) {
        news.setId(id);
        newsRepository.save(news);
    }
}
