package com.blog.adapters.rest.resources.blog;

import com.blog.adapters.rest.resources.ResourceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.blog.adapters.rest.resources.BasePath.BLOG_BASE_PATH;
import static com.blog.adapters.rest.resources.BaseRequestSpecification.createBlog;
import static com.blog.adapters.rest.resources.BaseResponseSpecification.CREATED_SPEC;
import static org.hamcrest.Matchers.*;


@DisplayName(BLOG_BASE_PATH)
class BlogResourceTest extends ResourceTest {

    @Nested
    @DisplayName("POST /blog")
    class post {

        @Test
        void should_create_blog() {
            UUID authorId = UUID.randomUUID();

            createBlog("Test Blog", "Something...", authorId)
                    .then()
                    .spec(CREATED_SPEC)
                    .body("id", notNullValue())
                    .body("title", is("Test Blog"))
                    .body("body", is("Something..."))
                    .body("authorId", is(authorId.toString()))
                    .header("Location", response -> containsString(BLOG_BASE_PATH + "/" + response.path("id")));
        }
    }

}
