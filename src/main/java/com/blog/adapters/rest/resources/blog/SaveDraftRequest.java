package com.blog.adapters.rest.resources.blog;


import com.blog.adapters.rest.resources.RequestDto;

class SaveDraftRequest implements RequestDto {
    public String title;
    public String body;
}
