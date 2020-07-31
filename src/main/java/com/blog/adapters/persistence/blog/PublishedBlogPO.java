package com.blog.adapters.persistence.blog;

import com.blog.adapters.persistence.PersistenceObject;
import com.blog.domain.PublishedBlog;

import java.time.Instant;

public class PublishedBlogPO implements PersistenceObject<PublishedBlog> {
    private String publishedTitle;
    private String publishedBody;
    private Instant publishedAt;

    protected PublishedBlogPO() {
    }

    protected PublishedBlogPO(String publishedTitle, String publishedBody, Instant publishedAt) {
        this.publishedTitle = publishedTitle;
        this.publishedBody = publishedBody;
        this.publishedAt = publishedAt;
    }

    // The persistence object needs to reflect the table structure.
    // The domain model and persistence object may have much different.
    // So, manual to convert between them is better than use object mapper like Orika.
    @Override
    public PublishedBlog toDomainModel() {
        return new PublishedBlog(publishedTitle, publishedBody, publishedAt);
    }

    // The persistence object needs to reflect the table structure.
    // The domain model and persistence object may have much different.
    // So, manual to convert between them is better than use object mapper like Orika.
    static PublishedBlogPO of(PublishedBlog published) {
        return published == null ? null : new PublishedBlogPO(
                published.getTitle(),
                published.getBody(),
                published.getPublishedAt());
    }

    public String getPublishedTitle() {
        return publishedTitle;
    }

    public String getPublishedBody() {
        return publishedBody;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }
}
