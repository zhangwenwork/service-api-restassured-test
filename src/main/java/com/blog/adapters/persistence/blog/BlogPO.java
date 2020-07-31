package com.blog.adapters.persistence.blog;

import com.blog.adapters.persistence.PersistenceObject;
import com.blog.domain.Blog;

import java.time.Instant;
import java.util.UUID;

public class BlogPO implements PersistenceObject<Blog> {

    private String id;
    private String title;
    private String body;
    private String authorId;
    private String status;
    private Instant createdAt;
    private Instant savedAt;
    private PublishedBlogPO published;

    protected BlogPO() {
    }

    protected BlogPO(String id, String title, String body,
                  String authorId, String status, Instant createdAt, Instant savedAt, PublishedBlogPO published) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorId = authorId;
        this.status = status;
        this.createdAt = createdAt;
        this.savedAt = savedAt;
        this.published = published;
    }

    // The persistence object needs to reflect the table structure.
    // The domain model and persistence object may have much different.
    // So, manual to convert between them is better than use object mapper like Orika.
    @Override
    public Blog toDomainModel() {
        return new Blog(
                UUID.fromString(id),
                title,
                body,
                UUID.fromString(authorId),
                Blog.Status.valueOf(status),
                createdAt,
                savedAt,
                published == null ? null : published.toDomainModel()
        );
    }

    // The persistence object needs to reflect the table structure.
    // The domain model and persistence object may have much different.
    // So, manual to convert between them is better than use object mapper like Orika.
    static BlogPO of(Blog blog) {
        return blog == null ? null : new BlogPO(
                blog.getId().toString(),
                blog.getTitle(),
                blog.getBody(),
                blog.getAuthorId().toString(),
                blog.getStatus().toString(),
                blog.getCreatedAt(),
                blog.getSavedAt(),
                PublishedBlogPO.of(blog.getPublished()));
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getSavedAt() {
        return savedAt;
    }

    public PublishedBlogPO getPublished() {
        return published;
    }
}
