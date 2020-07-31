package com.blog.application;

import com.blog.domain.Blog;
import com.blog.domain.BlogRepository;
import com.blog.domain.BlogService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QueryBlogUseCase{
    private final BlogService blogService;
    private final BlogRepository blogRepository;

    public QueryBlogUseCase(BlogRepository blogRepository) {
        // 依赖注入是一种应用需要和技术实现细节，所以在 UseCase 里使用依赖注入框架，通过实例化 DomainService 并注入相关依赖的方式实现了 Domain 与技术框架的解耦。
        this.blogService = new BlogService(blogRepository);
        this.blogRepository = blogRepository;
    }

    public Blog get(UUID id) {
        return blogService.get(id);
    }

}
