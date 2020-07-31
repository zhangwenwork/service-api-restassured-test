package com.blog.domain;

import com.google.common.base.Objects;

import java.time.Instant;

public class PublishedBlog{
    private final String title;
    private final String body;
    private final Instant publishedAt;

    public PublishedBlog(String title, String body, Instant publishedAt) {
        this.title = title;
        this.body = body;
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishedBlog that = (PublishedBlog) o;
        return Objects.equal(title, that.title) &&
                Objects.equal(body, that.body) &&
                Objects.equal(publishedAt, that.publishedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, body, publishedAt);
    }
}
