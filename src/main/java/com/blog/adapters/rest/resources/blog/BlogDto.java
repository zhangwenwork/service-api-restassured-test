package com.blog.adapters.rest.resources.blog;

import com.blog.adapters.rest.resources.ResponseDto;
import com.blog.domain.Blog;

import java.time.Instant;
import java.util.UUID;

class BlogDto implements ResponseDto {
    private UUID id;
    private String title;
    private String body;
    private UUID authorId;
    private Blog.Status status;
    private Instant createdAt;
    private Instant savedAt;

    public BlogDto(UUID id, String title, String body,
                   UUID authorId, Blog.Status status, Instant createdAt, Instant savedAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorId = authorId;
        this.status = status;
        this.createdAt = createdAt;
        this.savedAt = savedAt;
    }

    static BlogDto of(Blog blog) {
        return new BlogDto(
                blog.getId(),
                blog.getTitle(),
                blog.getBody(),
                blog.getAuthorId(),
                blog.getStatus(),
                blog.getCreatedAt(),
                blog.getSavedAt());
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public Blog.Status getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getSavedAt() {
        return savedAt;
    }
}
