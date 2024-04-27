package ru.kravchenko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.model.News;
import ru.kravchenko.repository.NewsRepository;
import ru.kravchenko.service.NewsService;
import ru.kravchenko.service.dto.NewsDto;
import ru.kravchenko.service.exception.EntityNotFoundException;
import ru.kravchenko.service.mapper.NewsMapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    private final NewsMapper newsMapper;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    @Override
    public NewsDto findById(Long id) {
        return newsMapper.toDto(newsRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id)
        ));
    }

    @Override
    public List<NewsDto> findAllNews() {
        return convertList(newsRepository.findAll());
    }

    @Transactional
    @Override
    public void saveNews(NewsDto newsDto) {
        newsRepository.save(newsMapper.toModel(newsDto));
    }

    @Transactional
    @Override
    public void removeNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateNews(Long id, NewsDto newsDto) {
        newsDto.setId(id);
        newsRepository.save(newsMapper.toModel(newsDto));
    }

    private List<NewsDto> convertList(List<News> newsList) {
        return newsList.isEmpty() ?
                Collections.emptyList() :
                newsList.stream().map(newsMapper::toDto).collect(Collectors.toList());
    }
}
