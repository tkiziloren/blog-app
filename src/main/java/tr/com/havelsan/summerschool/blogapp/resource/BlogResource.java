package tr.com.havelsan.summerschool.blogapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.havelsan.summerschool.blogapp.domain.Blog;
import tr.com.havelsan.summerschool.blogapp.domain.Post;
import tr.com.havelsan.summerschool.blogapp.repository.BlogRepository;
import tr.com.havelsan.summerschool.blogapp.repository.PostRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 7.8.2018.
 */
@RestController
public class BlogResource {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private PostRepository postRepository;


    @PostMapping("/blogs")
    public ResponseEntity<Object> createBlog(@RequestBody Blog blog) {
        Blog savedBlog = blogRepository.save(blog);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBlog.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @GetMapping("/blogs/{id}")
    public Optional<Blog> getBlog(@PathVariable int id){
        return blogRepository.findById(id);
    }

    @GetMapping("/blogs/{id}/posts")
    public List<Post> getPosts(@PathVariable int id){
        return postRepository.findAllByBlogId(id);
    }


}
