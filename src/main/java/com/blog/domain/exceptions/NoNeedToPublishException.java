package com.blog.domain.exceptions;

public class NoNeedToPublishException extends DomainException {
    public NoNeedToPublishException() {
        super("no need to publish");
    }
}
