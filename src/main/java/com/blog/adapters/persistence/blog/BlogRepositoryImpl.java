package com.blog.adapters.persistence.blog;

import com.blog.domain.BlogRepository;
import com.blog.domain.Blog;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public class BlogRepositoryImpl implements BlogRepository {

    private final BlogMapper blogMapper;

    public BlogRepositoryImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public void save(Blog blog) {
        BlogPO blogPO = BlogPO.of(blog);

        Optional<BlogPO> record = blogMapper.findById(blog.getId().toString());

        if (record.isPresent()) {
            blogMapper.update(blogPO);
        } else {
            blogMapper.insert(blogPO);
        }
    }

    @Override
    public Optional<Blog> findById(UUID id) {
        return blogMapper.findById(id.toString()).map(BlogPO::toDomainModel);
    }

    @Override
    public boolean existsById(UUID id) {
        return blogMapper.existsById(id.toString());
    }

    @Override
    public void deleteById(UUID id) {
        blogMapper.deleteById(id.toString());
    }

}

