package config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kravchenko.model.Comment;
import ru.kravchenko.model.News;
import ru.kravchenko.model.Tag;
import ru.kravchenko.repository.CommentRepository;
import ru.kravchenko.repository.NewsRepository;
import ru.kravchenko.repository.TagRepository;
import ru.kravchenko.service.CommentService;
import ru.kravchenko.service.NewsService;
import ru.kravchenko.service.TagService;
import ru.kravchenko.service.dto.CommentDto;
import ru.kravchenko.service.dto.NewsDto;
import ru.kravchenko.service.dto.TagDto;
import ru.kravchenko.service.exception.EntityNotFoundException;
import ru.kravchenko.service.impl.CommentServiceImpl;
import ru.kravchenko.service.impl.NewsServiceImpl;
import ru.kravchenko.service.impl.TagServiceImpl;
import ru.kravchenko.service.mapper.CommentMapper;
import ru.kravchenko.service.mapper.NewsMapper;
import ru.kravchenko.service.mapper.TagMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
public class TestConfig {

    @Bean
    public CommentDto commentDto() {
        return new CommentDto();
    }

    @Bean
    public News news() {
        return new News();
    }

    @Bean
    public NewsDto newsDto() {
        return new NewsDto();
    }

    @Bean
    public List<Comment> commentList() {
        return Arrays.asList(new Comment(), new Comment());
    }

    @Bean
    public TagDto tagDto() {
        return new TagDto();
    }

    @Bean
    public List<News> newsList() {
        return Arrays.asList(new News(), new News());
    }

    @Bean
    public Comment comment() {
        return new Comment();
    }

    @Bean
    public Tag tag() {
        return new Tag();
    }

    @Bean
    public CommentMapper commentMapper() {
        return Mappers.getMapper(CommentMapper.class);
    }

    @Bean
    public CommentRepository commentRepository() {
        CommentRepository commentRepository = mock(CommentRepository.class);
        Comment comment = new Comment();
        comment.setId(1L);
        Optional<Comment> commentOptional = Optional.of(comment);
        when(commentRepository.findById(1L)).thenReturn(commentOptional);
        when(commentRepository.findById(2L)).thenThrow(new EntityNotFoundException(2L));
        when(commentRepository.findAll()).thenReturn(new ArrayList<>());
        when(commentRepository.save(new Comment())).thenThrow(new EntityNotFoundException(2L));
        when(commentRepository.save(commentWithId())).thenThrow(new EntityNotFoundException(5L));
        return commentRepository;
    }

    @Bean
    public CommentService commentService() {
        return new CommentServiceImpl(commentRepository(), commentMapper());
    }

    @Bean
    public Comment commentWithId() {
        Comment comment = new Comment();
        comment.setId(5L);
        return comment;
    }

    @Bean
    public CommentDto commentDtoWithId() {
        return commentMapper().toDto(commentWithId());
    }

    @Bean
    public NewsMapper newsMapper() {
        return Mappers.getMapper(NewsMapper.class);
    }

    @Bean
    public NewsRepository newsRepository() {
        NewsRepository newsRepository = mock(NewsRepository.class);
        News news = new News();
        news.setId(1L);
        Optional<News> newsOptional = Optional.of(news);
        when(newsRepository.findById(1L)).thenReturn(newsOptional);
        when(newsRepository.findById(2L)).thenThrow(new EntityNotFoundException(2L));
        when(newsRepository.findAll()).thenReturn(new ArrayList<>());
        when(newsRepository.save(new News())).thenThrow(new EntityNotFoundException(2L));
        when(newsRepository.save(newsWithId())).thenThrow(new EntityNotFoundException(5L));
        return newsRepository;
    }

    @Bean
    public NewsService newsService() {
        return new NewsServiceImpl(newsRepository(), newsMapper());
    }

    @Bean
    public News newsWithId() {
        News news = new News();
        news.setId(5L);
        return news;
    }

    @Bean
    public NewsDto newsDtoWithId() {
        return newsMapper().toDto(newsWithId());
    }

    @Bean
    public TagMapper tagMapper() {
        return Mappers.getMapper(TagMapper.class);
    }

    @Bean
    public TagRepository tagRepository() {
        TagRepository tagRepository = mock(TagRepository.class);
        Tag tag = new Tag();
        tag.setId(1L);
        Optional<Tag> tagOptional = Optional.of(tag);
        when(tagRepository.findById(1L)).thenReturn(tagOptional);
        when(tagRepository.findById(2L)).thenThrow(new EntityNotFoundException(2L));
        when(tagRepository.findAll()).thenReturn(new ArrayList<>());
        when(tagRepository.save(new Tag())).thenThrow(new EntityNotFoundException(2L));
        return tagRepository;
    }

    @Bean
    public TagService tagService() {
        return new TagServiceImpl(tagRepository(), tagMapper());
    }
}
