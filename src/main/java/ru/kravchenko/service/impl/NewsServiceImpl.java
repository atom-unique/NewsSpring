package ru.kravchenko.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.model.News;
import ru.kravchenko.repository.NewsRepository;
import ru.kravchenko.repository.impl.NewsRepositoryImpl;
import ru.kravchenko.service.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(SessionFactory sessionFactory) {
        this.newsRepository = new NewsRepositoryImpl(sessionFactory);
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public List<News> findAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList.isEmpty() ? List.of() : newsList;
    }

    @Override
    public void saveNews(News news) {
        if (newsRepository.findOne(news.getId()) != null && news.getId() != null) {
            newsRepository.update(news);
        } else {
            newsRepository.create(news);
        }
    }

    @Override
    public void removeNews(Long id) {
        newsRepository.remove(id);
    }
}
