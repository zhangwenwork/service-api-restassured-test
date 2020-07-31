package com.blog.adapters.rest.resources.blog;

import com.blog.application.QueryBlogUseCase;
import com.blog.application.EditBlogUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/blog/{id}", produces = APPLICATION_JSON_VALUE)
public class BlogSubResource {
    private QueryBlogUseCase queryBlogUseCase;
    private EditBlogUseCase editBlogUseCase;

    public BlogSubResource(QueryBlogUseCase queryBlogUseCase, EditBlogUseCase editBlogUseCase) {
        this.queryBlogUseCase = queryBlogUseCase;
        this.editBlogUseCase = editBlogUseCase;
    }

    @GetMapping
    public BlogDto get(@PathVariable UUID id) {
        return BlogDto.of(queryBlogUseCase.get(id));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(NO_CONTENT)
    public void put(@PathVariable UUID id, @RequestBody SaveDraftRequest data) {
        editBlogUseCase.saveDraft(id, data.title, data.body);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        editBlogUseCase.delete(id);
    }
}
